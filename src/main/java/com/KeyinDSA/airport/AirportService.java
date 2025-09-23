package com.KeyinDSA.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        return airportRepository.findById(id).map(existing -> {
            existing.setCode(updatedAirport.getCode());
            existing.setAirportName(updatedAirport.getAirportName());
            existing.setCountry(updatedAirport.getCountry());
            existing.setCity(updatedAirport.getCity());
            return airportRepository.save(existing);
        }).orElse(null);
    }

    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
}
