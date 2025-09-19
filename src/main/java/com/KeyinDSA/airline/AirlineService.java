package com.KeyinDSA.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public List<Airline> getAllAirlines() {
        List<Airline> airlines = new ArrayList<>();
        airlineRepository.findAll().forEach(airlines::add);
        return airlines;
    }

    public Airline getAirlineById(int id){
        return airlineRepository.findById(id).orElse(null);
    }

    public Airline createAirline(Airline newAirline) {
        return airlineRepository.save(newAirline);
    }

    public void deleteAirlineById(int id) {
        airlineRepository.deleteById(id);
    }
}
