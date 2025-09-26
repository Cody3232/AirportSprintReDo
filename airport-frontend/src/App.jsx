import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [section, setSection] = useState("cities");
  const [data, setData] = useState([]);

  // load data whenever section changes
  useEffect(() => {
    fetch(`http://localhost:8080/${section}`)
      .then((res) => res.json())
      .then(setData)
      .catch((err) => console.error(`Error fetching ${section}:`, err));
  }, [section]);

  // table headers
  const renderHeaders = () => {
    switch (section) {
      case "cities":
        return (
          <tr>
            <th>City</th>
            <th>Population</th>
            <th>Airports</th>
          </tr>
        );
      case "passengers":
        return (
          <tr>
            <th>Passenger</th>
            <th>City</th>
            <th>Aircraft</th>
          </tr>
        );
      case "aircraft":
        return (
          <tr>
            <th>Aircraft</th>
            <th>Airline</th>
            <th>Departure</th>
            <th>Arrival</th>
          </tr>
        );
      case "airports":
        return (
          <tr>
            <th>Airport</th>
            <th>City</th>
            <th>Aircraft</th>
          </tr>
        );
      default:
        return null;
    }
  };

// table rows
const renderRow = (item) => {
  switch (section) {
    case "cities":
      return (
        <tr key={item.id}>
          <td>{item.name}</td>
          <td>{item.population}</td>
          <td>
            {item.airports?.length > 0 ? (
              item.airports.map((ap) => (
                <div key={ap.id}>
                  {ap.airportName} ({ap.code})
                </div>
              ))
            ) : (
              <em>No airports</em>
            )}
          </td>
        </tr>
      );
    case "passengers":
      return (
        <tr key={item.id}>
          <td>
            {item.firstName} {item.lastName}
          </td>
          <td>{item.city?.name || "—"}</td>
          <td>
            {item.aircraft?.length > 0 ? (
              item.aircraft.map((ac) => <div key={ac.id}>{ac.code}</div>)
            ) : (
              <em>No flights</em>
            )}
          </td>
        </tr>
      );
    case "aircraft":
      return (
        <tr key={item.id}>
          <td>{item.code}</td>
          <td>{item.airline?.name || "—"}</td>
          <td>{item.departureAirport?.airportName || "—"}</td>
          <td>{item.arrivalAirport?.airportName || "—"}</td>
        </tr>
      );
    case "airports":
      return (
        <tr key={item.id}>
          <td>{item.airportName}</td>
          <td>{item.city?.name || "—"}</td>
          <td>
            {item.aircraft?.length > 0 ? (
              item.aircraft.map((ac) => <div key={ac.id}>{ac.code}</div>)
            ) : (
              <em>No aircraft</em>
            )}
          </td>
        </tr>
      );
    default:
      return null;
  }
};

  return (
    <div className="app-container">
      <nav className="navbar">
        <h2>Airport Sprint</h2>
        <ul>
          <li onClick={() => setSection("cities")}>Cities</li>
          <li onClick={() => setSection("passengers")}>Passengers</li>
          <li onClick={() => setSection("aircraft")}>Aircraft</li>
          <li onClick={() => setSection("airports")}>Airports</li>
        </ul>
      </nav>

      <main>
        <h1>{section.charAt(0).toUpperCase() + section.slice(1)}</h1>

        <table className="data-table">
          <thead>{renderHeaders()}</thead>
          <tbody>{data.map((item) => renderRow(item))}</tbody>
        </table>
      </main>
    </div>
  );
}

export default App;
