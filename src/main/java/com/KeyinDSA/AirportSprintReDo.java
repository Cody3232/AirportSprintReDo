package com.KeyinDSA;

import com.KeyinDSA.airport.Airport;
import com.KeyinDSA.airport.AirportRepository;
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
}