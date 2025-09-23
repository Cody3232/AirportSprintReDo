package com.KeyinDSA.airport;

import com.KeyinDSA.city.City;
import jakarta.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String airportName;
    private String country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

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
}
