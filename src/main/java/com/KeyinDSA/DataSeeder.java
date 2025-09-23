package com.KeyinDSA;

import com.KeyinDSA.airline.Airline;
import com.KeyinDSA.airline.AirlineRepository;
import com.KeyinDSA.airport.Airport;
import com.KeyinDSA.airport.AirportRepository;
import com.KeyinDSA.city.City;
import com.KeyinDSA.city.CityRepository;
import com.KeyinDSA.aircraft.Aircraft;
import com.KeyinDSA.aircraft.AircraftRepository;
import com.KeyinDSA.passenger.Passenger;
import com.KeyinDSA.passenger.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final AirportRepository airportRepository;
    private final AirlineRepository airlineRepository;
    private final AircraftRepository aircraftRepository;
    private final PassengerRepository passengerRepository;

    public DataSeeder(CityRepository cityRepository,
                      AirportRepository airportRepository,
                      AirlineRepository airlineRepository,
                      AircraftRepository aircraftRepository,
                      PassengerRepository passengerRepository) {
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
        this.airlineRepository = airlineRepository;
        this.aircraftRepository = aircraftRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void run(String... args) {
        if (cityRepository.count() == 0 && airportRepository.count() == 0) {

            // Data comes from ChatGPT as time saver
            // --- Cities ---
            City stJohns = cityRepository.save(new City("St. John's", "NL", 110000));
            City newYork = cityRepository.save(new City("New York", "NY", 8400000));
            City london  = cityRepository.save(new City("London", "England", 8900000));
            City toronto = cityRepository.save(new City("Toronto", "ON", 2800000));
            City losAngeles = cityRepository.save(new City("Los Angeles", "CA", 3900000));
            City paris = cityRepository.save(new City("Paris", "France", 2140000));

            // --- Airports ---
            Airport yyt = airportRepository.save(new Airport("YYT", "St. John's International", "Canada", stJohns));
            Airport jfk = airportRepository.save(new Airport("JFK", "John F. Kennedy International", "USA", newYork));
            Airport lhr = airportRepository.save(new Airport("LHR", "London Heathrow", "UK", london));
            Airport yyz = airportRepository.save(new Airport("YYZ", "Toronto Pearson International", "Canada", toronto));
            Airport lax = airportRepository.save(new Airport("LAX", "Los Angeles International", "USA", losAngeles));
            Airport cdg = airportRepository.save(new Airport("CDG", "Charles de Gaulle", "France", paris));

            // --- Airlines ---
            Airline ac = airlineRepository.save(new Airline("AC", "Air Canada", "Canada"));
            Airline dl = airlineRepository.save(new Airline("DL", "Delta Airlines", "USA"));
            Airline ba = airlineRepository.save(new Airline("BA", "British Airways", "UK"));
            Airline aa = airlineRepository.save(new Airline("AA", "American Airlines", "USA"));
            Airline af = airlineRepository.save(new Airline("AF", "Air France", "France"));
            Airline ws = airlineRepository.save(new Airline("WS", "WestJet", "Canada"));

            // --- Aircraft (using Airline + Airports directly) ---
            Aircraft ac101 = aircraftRepository.save(new Aircraft("AC101", ac, yyt, jfk, 800, 1030));
            Aircraft dl200 = aircraftRepository.save(new Aircraft("DL200", dl, jfk, lhr, 1300, 2100));
            Aircraft ba150 = aircraftRepository.save(new Aircraft("BA150", ba, lhr, yyt, 900, 1130));
            Aircraft aa300 = aircraftRepository.save(new Aircraft("AA300", aa, lax, jfk, 1430, 1900));
            Aircraft af400 = aircraftRepository.save(new Aircraft("AF400", af, cdg, lhr, 700, 830));
            Aircraft ws500 = aircraftRepository.save(new Aircraft("WS500", ws, yyz, yyt, 1600, 1830));

            // --- Passengers ---
            Passenger p1 = new Passenger("Alice", "Smith", "709-555-1234", stJohns);
            p1.getAircraft().add(ac101);

            Passenger p2 = new Passenger("Bob", "Johnson", "212-555-5678", newYork);
            p2.getAircraft().add(dl200);

            Passenger p3 = new Passenger("Charlie", "Brown", "020-555-9012", london);
            p3.getAircraft().add(ba150);

            Passenger p4 = new Passenger("Diana", "Lopez", "416-555-2222", toronto);
            p4.getAircraft().add(ws500);

            Passenger p5 = new Passenger("Ethan", "Williams", "310-555-3333", losAngeles);
            p5.getAircraft().add(aa300);

            Passenger p6 = new Passenger("Fiona", "Dupont", "01-55-66-77-88", paris);
            p6.getAircraft().add(af400);

            passengerRepository.save(p1);
            passengerRepository.save(p2);
            passengerRepository.save(p3);
            passengerRepository.save(p4);
            passengerRepository.save(p5);
            passengerRepository.save(p6);

            System.out.println("Expanded sample data seeded into MySQL!");
        }
    }
}
