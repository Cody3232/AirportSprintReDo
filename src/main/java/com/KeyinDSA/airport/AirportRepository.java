package com.KeyinDSA.airport;

import com.KeyinDSA.city.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
    Airport findByAirportName(String name);
    Airport findByCode(String code);
    List<Airport> findByCountry(String country);
    List<Airport> findByCity(City city);
}
