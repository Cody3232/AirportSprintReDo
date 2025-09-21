package com.KeyinDSA.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        Flight flight = flightService.getFlightById(id);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flight);
        }
    }

    @PostMapping("/flight")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @DeleteMapping("/flight/{id}")
    public void deleteFlightById(@PathVariable int id) {
        flightService.deleteFlightById(id);
    }
}
