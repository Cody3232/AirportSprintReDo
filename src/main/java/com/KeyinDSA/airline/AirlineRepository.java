package com.KeyinDSA.airline;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {
    Airline findByCode(String code);
    Airline findByName(String name);
    Airline findByCountry(String country);
}
