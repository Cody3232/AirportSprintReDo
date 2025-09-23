package com.KeyinDSA.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger createPassenger(Passenger newPassenger) {
        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        return passengerRepository.findById(id).map(existing -> {
            existing.setFirstName(updatedPassenger.getFirstName());
            existing.setLastName(updatedPassenger.getLastName());
            existing.setPhoneNumber(updatedPassenger.getPhoneNumber());
            existing.setCity(updatedPassenger.getCity());
            existing.setAircraft(updatedPassenger.getAircraft());
            return passengerRepository.save(existing);
        }).orElse(null);
    }

    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(id);
    }
}
