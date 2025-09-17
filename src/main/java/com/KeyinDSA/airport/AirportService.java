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

    public Airport getAirportById(int id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }

    public void deleteAirportById(int id) {
        airportRepository.deleteById(id);
    }

}
