package com.capgemini.flightmanagementsystem.flightservice.model;





import org.springframework.stereotype.Component;

@Component
public class Flight {
	public long flightNumber;
	
	public String flightModel;
	public String carrierName;
	public int seatCapacity;
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
	public Flight(long flightnumber, String flightmodel, String carriername, int seatcapacity) {
		super();
		this.flightNumber=flightnumber;
		this.carrierName=carriername;
		this.flightModel=flightmodel;
		this.seatCapacity=seatcapacity;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
}
