package com.KeyinDSA.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> getAllAircraft() {
        List<Aircraft> aircraft = new ArrayList<>();
        aircraftRepository.findAll().forEach(aircraft::add);
        return aircraft;
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public Aircraft createAircraft(Aircraft newAircraft) {
        return aircraftRepository.save(newAircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        return aircraftRepository.findById(id).map(existing -> {
            existing.setCode(updatedAircraft.getCode());
            existing.setAirline(updatedAircraft.getAirline());
            existing.setDepartureAirport(updatedAircraft.getDepartureAirport());
            existing.setArrivalAirport(updatedAircraft.getArrivalAirport());
            existing.setDepartureTime(updatedAircraft.getDepartureTime());
            existing.setArrivalTime(updatedAircraft.getArrivalTime());
            return aircraftRepository.save(existing);
        }).orElse(null);
    }

    public void deleteAircraftById(Long id) {
        aircraftRepository.deleteById(id);
    }
}
