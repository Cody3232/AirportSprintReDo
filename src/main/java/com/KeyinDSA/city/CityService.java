package com.KeyinDSA.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public City updateCity(Long id, City updatedCity) {
        return cityRepository.findById(id).map(existing -> {
            existing.setName(updatedCity.getName());
            existing.setState(updatedCity.getState());
            existing.setPopulation(updatedCity.getPopulation());
            return cityRepository.save(existing);
        }).orElse(null);
    }

    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }
}
