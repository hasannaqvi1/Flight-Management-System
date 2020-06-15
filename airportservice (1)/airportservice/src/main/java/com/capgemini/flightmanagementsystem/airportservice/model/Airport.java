package com.capgemini.flightmanagementsystem.airportservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Airport {
	
	private String airportName;
	
	private String airportCode;
	
	private String airportLocation;
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public Airport() {}
	public Airport(String airportName, String airportCode, String airportLocation) {
		this.airportName=airportName;
		this.airportCode=airportCode;
		this.airportLocation=airportLocation;
	}
	
}

