package com.KeyinDSA.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public List<Airline> getAllAirlines(){
        return airlineService.getAllAirlines();
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable int id) {
        Airline airline = airlineService.getAirlineById(id);
        if (airline == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(airline);
        }
    }

    @PostMapping("/airline")
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.createAirline(airline);
    }

    @DeleteMapping("/airline/{id}")
    public void deleteAirlineById(@PathVariable int id) {
        airlineService.deleteAirlineById(id);
    }
}
