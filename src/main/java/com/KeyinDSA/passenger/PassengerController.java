package com.KeyinDSA.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        return passenger == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(passenger);
    }

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @PutMapping("/passenger/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Passenger updated = passengerService.updatePassenger(id, passenger);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/passenger/{id}")
    public void deletePassengerById(@PathVariable Long id) {
        passengerService.deletePassengerById(id);
    }
}
