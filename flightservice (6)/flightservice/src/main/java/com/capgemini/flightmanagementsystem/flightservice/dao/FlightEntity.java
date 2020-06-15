package com.capgemini.flightmanagementsystem.flightservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Flight")
public class FlightEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flight_number")
	@Id
	private long flightNumber;
	@Column(name="flight_model")
	@NotBlank(message="Model Name is mandatory")
	@NotNull(message="Model Name is mandatory")
	@Size(min = 1, max = 8, message="Flight model must be equal to or greater than 1 character and less than 8")
	private String flightModel;
	@Column(name="carrier_name")
	@NotBlank(message="Model Name is mandatory")
	@NotNull(message="Model Name is mandatory")
	@Size(min = 2, max = 8, message="Carrier Name must be equal to or greater than 2 character and less than 8")
	private String carrierName;
	@Column(name="seat_capacity")
	private int seatCapacity;
	public long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public FlightEntity(long flightNumber,
			@NotBlank(message = "Model Name is mandatory") @NotNull(message = "Model Name is mandatory") String flightModel,
			@NotBlank(message = "Model Name is mandatory") @NotNull(message = "Model Name is mandatory") String carrierName,
			int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}
	public FlightEntity() {
		
	}
	
}
