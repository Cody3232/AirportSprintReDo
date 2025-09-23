package com.KeyinDSA.aircraft;

import com.KeyinDSA.airline.Airline;
import com.KeyinDSA.airport.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    Aircraft findByCode(String code);

    List<Aircraft> findByAirline(Airline airline);

    List<Aircraft> findByDepartureAirport(Airport departureAirport);

    List<Aircraft> findByArrivalAirport(Airport arrivalAirport);
}
