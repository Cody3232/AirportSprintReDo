package com.KeyinDSA.airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Integer> {
    Airport findByAirportName(String name);
    Airport findByCode(String code);
    Airport findByCity(String city);
    Airport findByCountry(String country);
}
