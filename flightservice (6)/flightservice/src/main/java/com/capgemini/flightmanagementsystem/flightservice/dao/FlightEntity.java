package com.capgemini.flightmanagementsystem.flightservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	private String flightModel;
	@Column(name="carrier_name")
	@NotBlank(message="Model Name is mandatory")
	@NotNull(message="Model Name is mandatory")
	private String carrierName;
	@Column(name="seat_capacity")
	private int seatCapacity;
	public long getFlightnumber() {
		return flightNumber;
	}
	public void setFlightnumber(long flightnumber) {
		this.flightNumber = flightnumber;
	}
	public String getFlightmodel() {
		return flightModel;
	}
	public void setFlightmodel(String flightmodel) {
		this.flightModel = flightmodel;
	}
	public String getCarriername() {
		return carrierName;
	}
	public void setCarriername(String carriername) {
		this.carrierName = carriername;
	}
	public int getSeatcapacity() {
		return seatCapacity;
	}
	public void setSeatcapacity(int seatcapacity) {
		this.seatCapacity = seatcapacity;
	}
	@Override
	public String toString() {
		return "Flight [flightnumber=" + flightNumber + ", flightmodel=" + flightModel + ", carriername=" + carrierName
				+ ", seatcapacity=" + seatCapacity + "]";
	}
	public FlightEntity(long flightnumber, String flightmodel, String carriername, int seatcapacity) {
		super();
		this.flightNumber=flightnumber;
		this.carrierName=carriername;
		this.flightModel=flightmodel;
		this.seatCapacity=seatcapacity;
	}
	public FlightEntity() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
