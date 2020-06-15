package com.capgemini.flightmanagementsystem.flightservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.flightservice.dao.FlightEntity;
import com.capgemini.flightmanagementsystem.flightservice.exception.FlightNotFoundException;
import com.capgemini.flightmanagementsystem.flightservice.model.Flight;

@Service
public interface FlightService {
	public List<Flight> viewFlight();
	public FlightEntity viewFlightById(long flightnumber) throws FlightNotFoundException;
	public String addFlight(@Valid Flight flight);
	public String updateFlightgById(long flightnumber, Flight flight)throws FlightNotFoundException;
	public String deleteFlightById(long flightnumber)throws FlightNotFoundException;
}
