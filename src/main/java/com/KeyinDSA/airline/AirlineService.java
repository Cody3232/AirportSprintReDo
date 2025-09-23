package com.KeyinDSA.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public List<Airline> getAllAirlines() {
        return (List<Airline>) airlineRepository.findAll();
    }

    public Airline getAirlineById(Long id) {
        return airlineRepository.findById(id).orElse(null);
    }

    public Airline createAirline(Airline newAirline) {
        return airlineRepository.save(newAirline);
    }

    public Airline updateAirline(Long id, Airline updatedAirline) {
        return airlineRepository.findById(id).map(existing -> {
            existing.setCode(updatedAirline.getCode());
            existing.setName(updatedAirline.getName());
            existing.setCountry(updatedAirline.getCountry());
            return airlineRepository.save(existing);
        }).orElse(null);
    }

    public void deleteAirlineById(Long id) {
        airlineRepository.deleteById(id);
    }
}
