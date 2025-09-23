import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [section, setSection] = useState("cities");
  const [data, setData] = useState([]);
  const [formData, setFormData] = useState({});

  // map plural → singular for endpoints
  const endpoints = {
    cities: "city",
    airlines: "airline",
    airports: "airport",
    aircraft: "aircraft",
    passengers: "passenger",
  };

  // load data whenever section changes
  useEffect(() => {
    fetch(`http://localhost:8080/${section}`)
      .then((res) => res.json())
      .then(setData)
      .catch((err) => console.error(`Error fetching ${section}:`, err));
  }, [section]);

  // handle form input
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // CREATE
  const handleCreate = (e) => {
    e.preventDefault();
    const endpoint = endpoints[section];

    fetch(`http://localhost:8080/${endpoint}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json())
      .then((newItem) => setData([...data, newItem]))
      .catch((err) => console.error("Error creating:", err));

    setFormData({});
    e.target.reset();
  };

  // UPDATE
  const handleUpdate = (id) => {
    const endpoint = endpoints[section];
    fetch(`http://localhost:8080/${endpoint}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json())
      .then((updated) => {
        setData(data.map((item) => (item.id === id ? updated : item)));
        setFormData({});
      })
      .catch((err) => console.error("Error updating:", err));
  };

  // DELETE
  const handleDelete = (id) => {
    const endpoint = endpoints[section];
    fetch(`http://localhost:8080/${endpoint}/${id}`, { method: "DELETE" })
      .then(() => setData(data.filter((item) => item.id !== id)))
      .catch((err) => console.error("Error deleting:", err));
  };

  // form fields per section
  const getFields = () => {
    switch (section) {
      case "cities":
        return ["name", "state", "population"];
      case "airlines":
        return ["code", "name", "country"];
      case "airports":
        return ["code", "airportName", "country"];
      case "aircraft":
        return ["code", "departureTime", "arrivalTime"];
      case "passengers":
        return ["firstName", "lastName", "phoneNumber"];
      default:
        return [];
    }
  };

  // display formatting per section
  const renderItem = (item) => {
    switch (section) {
      case "cities":
        return (
          <>
            🏙 <strong>{item.name}</strong> — {item.state} (Pop: {item.population})
          </>
        );
      case "airlines":
        return (
          <>
            ✈️ <strong>{item.name}</strong> ({item.code}) — {item.country}
          </>
        );
      case "airports":
        return (
          <>
            🛫 <strong>{item.airportName}</strong> ({item.code}) — {item.country}
          </>
        );
      case "aircraft":
        return (
          <>
            🛩 <strong>{item.code}</strong> — Dep: {item.departureTime}, Arr: {item.arrivalTime}
          </>
        );
      case "passengers":
        return (
          <>
            👤 <strong>{item.firstName} {item.lastName}</strong> — {item.phoneNumber}
          </>
        );
      default:
        return JSON.stringify(item);
    }
  };

  return (
    <div className="app-container">
      {/* Navbar */}
      <nav className="navbar">
        <h2>Airport Sprint</h2>
        <ul>
          <li onClick={() => setSection("cities")}>Cities</li>
          <li onClick={() => setSection("airlines")}>Airlines</li>
          <li onClick={() => setSection("airports")}>Airports</li>
          <li onClick={() => setSection("aircraft")}>Aircraft</li>
          <li onClick={() => setSection("passengers")}>Passengers</li>
        </ul>
      </nav>

      <main>
        <h1>{section.charAt(0).toUpperCase() + section.slice(1)}</h1>

        {/* form */}
        <form onSubmit={handleCreate} className="crud-form">
          {getFields().map((field) => (
            <input
              key={field}
              name={field}
              placeholder={field}
              value={formData[field] || ""}
              onChange={handleChange}
              required
            />
          ))}
          <button type="submit">Add</button>
        </form>

        {/* list */}
        <ul className="data-list">
          {data.map((item) => (
            <li key={item.id}>
              {renderItem(item)}
              <div className="actions">
                <button onClick={() => handleUpdate(item.id)}>Update</button>
                <button onClick={() => handleDelete(item.id)}>Delete</button>
              </div>
            </li>
          ))}
        </ul>
      </main>
    </div>
  );
}

export default App;
