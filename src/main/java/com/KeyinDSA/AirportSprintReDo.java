package com.KeyinDSA;

import com.KeyinDSA.airline.Airline;
import com.KeyinDSA.airline.AirlineRepository;
import com.KeyinDSA.airport.Airport;
import com.KeyinDSA.airport.AirportRepository;
import com.KeyinDSA.flight.Flight;
import com.KeyinDSA.flight.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirportSprintReDo {
    public static void main(String[] args) {
        SpringApplication.run(AirportSprintReDo.class, args);
    }

    // Using CommandLineRunner so that the App has Data to work with when it runs automatically
    @Bean
    public CommandLineRunner loadData(AirportRepository airportRepository) {
        return (args) -> {
            airportRepository.deleteAll(); // Prevents duplicates of samples on repeat runs

            airportRepository.save(new Airport("YYT", "St. John's International Airport", "St. Johns", "Canada"));
            airportRepository.save(new Airport("JFK", "John F. Kennedy International Airport", "New York", "USA"));
            airportRepository.save(new Airport("LHR", "London Heathrow Airport", "London", "UK"));

            System.out.println("Sample airports!");
        };
    }

    @Bean
    public CommandLineRunner loadAirlines(AirlineRepository airlineRepository) {
        return (args) -> {
            // Adding some sample airlines
            airlineRepository.save(new Airline("AC", "Air Canada", "Canada"));
            airlineRepository.save(new Airline("DL", "Delta Airlines", "USA"));
            airlineRepository.save(new Airline("BA", "British Airways", "UK"));

            System.out.println("Sample airlines!");
        };
    }

    @Bean
    public CommandLineRunner loadFlights(FlightRepository flightRepository) {
        return (args) -> {
            // Adding some sample flights
            flightRepository.save(new Flight("AC101", "Air Canada", "YYT", "JFK", 800, 1030));
            flightRepository.save(new Flight("DL200", "Delta Airlines", "JFK", "LHR", 1300, 2100));
            flightRepository.save(new Flight("BA150", "British Airways", "LHR", "YYT", 900, 1130));

            System.out.println("Sample flights!");
        };
    }
}