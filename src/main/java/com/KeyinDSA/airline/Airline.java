package com.KeyinDSA.airline;

import com.KeyinDSA.aircraft.Aircraft;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String country;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"airline", "departureAirport", "arrivalAirport", "passengers", "airports"})
    private Set<Aircraft> aircraft = new HashSet<>();

    public Airline() {}

    public Airline(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Aircraft> getAircraft() {
        return aircraft;
    }
    public void setAircraft(Set<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}
