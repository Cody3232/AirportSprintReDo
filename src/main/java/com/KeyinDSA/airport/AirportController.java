package com.KeyinDSA.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable int id) {
        Airport airport = airportService.getAirportById(id);
        if (airport == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(airport);
        }
    }

    @PostMapping("/airport")
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @DeleteMapping("/airport/{id}")
    public void deleteAirportById(@PathVariable int id) {
        airportService.deleteAirportById(id);
    }
}
