package com.KeyinDSA.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
        Airline airline = airlineService.getAirlineById(id);
        return airline == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(airline);
    }

    @PostMapping("/airline")
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.createAirline(airline);
    }

    @PutMapping("/airline/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
        Airline updated = airlineService.updateAirline(id, airline);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/airline/{id}")
    public void deleteAirlineById(@PathVariable Long id) {
        airlineService.deleteAirlineById(id);
    }
}
