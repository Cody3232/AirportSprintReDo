package com.KeyinDSA.flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {

    Flight findByCode(String code);

    List<Flight> findByDepartureAirportCode(String departureAirportCode);
    List<Flight> findByArrivalAirportCode(String arrivalAirportCode);
    List<Flight> findByAirlineName(String airlineName);

}
