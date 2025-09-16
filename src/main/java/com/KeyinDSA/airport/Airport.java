package com.KeyinDSA.airport;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Airport {

    @Id
    @SequenceGenerator(
            name = "airport_sequence",
            sequenceName = "airport_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            generator = "airport_sequence"
    )

    private int id;

    private String code;
    private String airportName;
    private String city;
    private String country;

    // Default constructor
    public Airport() {}

    public Airport(String code, String airportName, String city, String country) {
        this.code = code;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    // Getters and Setter for the airport fields
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

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}



