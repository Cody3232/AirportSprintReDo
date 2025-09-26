package com.KeyinDSA.airport;

import com.KeyinDSA.aircraft.Aircraft;
import com.KeyinDSA.city.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String airportName;
    private String country;

    // Airport belongs to one City
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"airports"})
    private City city;

    // An Airport can have many Aircraft
    @ManyToMany
    @JoinTable(
            name = "airport_aircraft",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    @JsonIgnoreProperties({"airports", "airline", "passengers"})
    private Set<Aircraft> aircraft = new HashSet<>();

    public Airport() {}

    public Airport(String code, String airportName, String country, City city) {
        this.code = code;
        this.airportName = airportName;
        this.country = country;
        this.city = city;
    }

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public Set<Aircraft> getAircraft() {
        return aircraft;
    }
    public void setAircraft(Set<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}
