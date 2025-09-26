// Generated points of data by ChatGPT

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
        if (cityRepository.count() == 0) {

            // --- Step 1: Save Cities ---
            City stJohns = cityRepository.save(new City("St. John's", "NL", 110000));
            City newYork = cityRepository.save(new City("New York", "NY", 8400000));
            City london  = cityRepository.save(new City("London", "England", 8900000));
            City toronto = cityRepository.save(new City("Toronto", "ON", 2800000));
            City losAngeles = cityRepository.save(new City("Los Angeles", "CA", 3900000));
            City paris = cityRepository.save(new City("Paris", "France", 2140000));

            // --- Step 2: Save Airlines ---
            Airline ac = airlineRepository.save(new Airline("AC", "Air Canada", "Canada"));
            Airline dl = airlineRepository.save(new Airline("DL", "Delta Airlines", "USA"));
            Airline ba = airlineRepository.save(new Airline("BA", "British Airways", "UK"));
            Airline aa = airlineRepository.save(new Airline("AA", "American Airlines", "USA"));
            Airline af = airlineRepository.save(new Airline("AF", "Air France", "France"));
            Airline ws = airlineRepository.save(new Airline("WS", "WestJet", "Canada"));

            // --- Step 3: Save Airports ---
            Airport yyt = airportRepository.save(new Airport("YYT", "St. John's International", "Canada", stJohns));
            Airport jfk = airportRepository.save(new Airport("JFK", "John F. Kennedy International", "USA", newYork));
            Airport lga = airportRepository.save(new Airport("LGA", "LaGuardia", "USA", newYork));
            Airport lhr = airportRepository.save(new Airport("LHR", "London Heathrow", "UK", london));
            Airport lgw = airportRepository.save(new Airport("LGW", "London Gatwick", "UK", london));
            Airport yyz = airportRepository.save(new Airport("YYZ", "Toronto Pearson International", "Canada", toronto));
            Airport lax = airportRepository.save(new Airport("LAX", "Los Angeles International", "USA", losAngeles));
            Airport bur = airportRepository.save(new Airport("BUR", "Hollywood Burbank Airport", "USA", losAngeles));
            Airport cdg = airportRepository.save(new Airport("CDG", "Charles de Gaulle", "France", paris));

            // --- Step 4: Save Aircraft (Airline + Airports already exist) ---
            Aircraft ac101 = aircraftRepository.save(new Aircraft("AC101", ac, yyt, jfk, 800, 1030));
            Aircraft ac102 = aircraftRepository.save(new Aircraft("AC102", ac, yyz, lga, 1400, 1630));
            Aircraft dl200 = aircraftRepository.save(new Aircraft("DL200", dl, jfk, lhr, 1300, 2100));
            Aircraft dl201 = aircraftRepository.save(new Aircraft("DL201", dl, lga, cdg, 900, 1700));
            Aircraft ba150 = aircraftRepository.save(new Aircraft("BA150", ba, lhr, yyt, 900, 1130));
            Aircraft ba151 = aircraftRepository.save(new Aircraft("BA151", ba, lgw, yyz, 1500, 1800));
            Aircraft aa300 = aircraftRepository.save(new Aircraft("AA300", aa, lax, jfk, 1430, 1900));
            Aircraft af400 = aircraftRepository.save(new Aircraft("AF400", af, cdg, lhr, 700, 830));
            Aircraft ws500 = aircraftRepository.save(new Aircraft("WS500", ws, yyz, yyt, 1600, 1830));

            // --- Step 5: Link Aircraft back to Airports (many-to-many sync) ---
            yyt.getAircraft().add(ac101); yyt.getAircraft().add(ba150); yyt.getAircraft().add(ws500);
            jfk.getAircraft().add(ac101); jfk.getAircraft().add(dl200); jfk.getAircraft().add(aa300);
            lga.getAircraft().add(ac102); lga.getAircraft().add(dl201);
            lhr.getAircraft().add(dl200); lhr.getAircraft().add(af400);
            lgw.getAircraft().add(ba151);
            yyz.getAircraft().add(ac102); yyz.getAircraft().add(ba151); yyz.getAircraft().add(ws500);
            lax.getAircraft().add(aa300);
            cdg.getAircraft().add(dl201); cdg.getAircraft().add(af400);

            airportRepository.save(yyt);
            airportRepository.save(jfk);
            airportRepository.save(lga);
            airportRepository.save(lhr);
            airportRepository.save(lgw);
            airportRepository.save(yyz);
            airportRepository.save(lax);
            airportRepository.save(bur);
            airportRepository.save(cdg);

            // --- Step 6: Save Passengers (after Aircraft exist) ---
            Passenger luke = passengerRepository.save(new Passenger("Luke", "Skywalker", "709-555-1234", stJohns));
            luke.getAircraft().add(ac101); luke.getAircraft().add(ws500);

            Passenger leia = passengerRepository.save(new Passenger("Leia", "Organa", "212-555-5678", newYork));
            leia.getAircraft().add(dl200); leia.getAircraft().add(dl201);

            Passenger han = passengerRepository.save(new Passenger("Han", "Solo", "020-555-9012", london));
            han.getAircraft().add(ba150);

            Passenger chewie = passengerRepository.save(new Passenger("Chewbacca", "", "416-555-2222", toronto));
            chewie.getAircraft().add(ws500);

            Passenger vader = passengerRepository.save(new Passenger("Darth", "Vader", "310-555-3333", losAngeles));
            vader.getAircraft().add(aa300);

            Passenger yoda = passengerRepository.save(new Passenger("Yoda", "", "015-556-7788", paris));
            yoda.getAircraft().add(af400);

            passengerRepository.save(luke);
            passengerRepository.save(leia);
            passengerRepository.save(han);
            passengerRepository.save(chewie);
            passengerRepository.save(vader);
            passengerRepository.save(yoda);

            System.out.println("DataSeeder complete: Cities ↔ Airports ↔ Aircraft ↔ Passengers loaded!");
        }
    }
}
