package com.KeyinDSA.flight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Flight {

    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            generator = "flight_sequence"
    )

    private int id;

    private String code;
    private String airlineName;
    private String arrivalAirportCode;
    private String departureAirportCode;
    private int departureTime;
    private int arrivalTime;

    // Default constructor
    public Flight() {
    }

    //Constructor looked messy with so many parameters, hence the different spacing on this one
    public Flight(
            String code,
            String airlineName,
            String arrivalAirportCode,
            String departureAirportCode,
            int departureTime,
            int arrivalTime
    ) {
        this.code = code;
        this.airlineName = airlineName;
        this.arrivalAirportCode = arrivalAirportCode;
        this.departureAirportCode = departureAirportCode;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

// Getters and setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }
    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }
    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public int getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}