package com.KeyinDSA.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    // GET all aircraft
    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    // GET single aircraft by ID
    @GetMapping("/aircraft/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Aircraft aircraft = aircraftService.getAircraftById(id);
        if (aircraft == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aircraft);
    }

    // POST - create a new aircraft
    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    // PUT - update an existing aircraft
    @PutMapping("/aircraft/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        Aircraft updated = aircraftService.updateAircraft(id, aircraft);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE - remove an aircraft
    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraftById(@PathVariable Long id) {
        aircraftService.deleteAircraftById(id);
    }
}
