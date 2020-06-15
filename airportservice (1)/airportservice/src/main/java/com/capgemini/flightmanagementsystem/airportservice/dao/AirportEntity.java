package com.capgemini.flightmanagementsystem.airportservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Airport")
public class AirportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="airportcode")
	@NotBlank(message="Airport Code is mandatory")
	@NotNull(message="Airport Code is mandatory")
	private String airportCode;
	@Column(name="airportname")
	@NotBlank(message="Airport Name is mandatory")
	@NotNull(message="Airport Name is mandatory")
	private String airportName;
	@Column(name="airportlocation")
	@NotBlank(message="Airport Location is mandatory")
	@NotNull(message="Airport Location is mandatory")
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
	public AirportEntity(String airportName, String airportCode, String airportLocation) {
		super();
		this.airportName = airportName;
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
	}
	public AirportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
