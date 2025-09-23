package com.KeyinDSA.city;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    City findByName(String name);
    List<City> findByState(String state);
}
