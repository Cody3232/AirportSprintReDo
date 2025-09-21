package com.KeyinDSA.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        return flights;
    }

    public Flight getFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight newFlight) {
        return flightRepository.save(newFlight);
    }

    public void deleteFlightById(int id) {
        flightRepository.deleteById(id);
    }
}
