package com.capgemini.flightmanagementsystem.flightservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.flightservice.dao.FlightEntity;
import com.capgemini.flightmanagementsystem.flightservice.dao.FlightRepository;
import com.capgemini.flightmanagementsystem.flightservice.exception.FlightNotFoundException;
import com.capgemini.flightmanagementsystem.flightservice.model.Flight;

@Service
public class FlightServiceImpl implements FlightService {
@Autowired
FlightRepository repository;
	
	@Override
	public List<Flight> viewFlight() {
		List<FlightEntity> entityList=repository.findAll();
		List<Flight> newFlightList = new ArrayList<>();
		for (FlightEntity entity : entityList) {
			Flight flight = new Flight();
			flight.setFlightnumber(entity.getFlightnumber());
			flight.setFlightmodel(entity.getFlightmodel());
			flight.setCarriername(entity.getCarriername());
			flight.setSeatcapacity(entity.getSeatcapacity());
			
			newFlightList.add(flight);
	}
		return newFlightList;
	}

	@Override
	public FlightEntity viewFlightById(long flightnumber) throws FlightNotFoundException {
		Optional<FlightEntity> entity = repository.findById(flightnumber);
		if(entity.isPresent()) {
			return entity.get();
		}
		else {
			throw new FlightNotFoundException("Flight not found for the given flight number");
		}
	}


	

	@Override
	public String updateFlightgById(long flightnumber, Flight flight) throws FlightNotFoundException {
		Optional<FlightEntity> optional = repository.findById(flightnumber);
		if(optional.isPresent()) {
			FlightEntity entity = optional.get();
			entity.setFlightnumber(entity.getFlightnumber());
			entity.setFlightmodel(entity.getFlightmodel());
			entity.setCarriername(entity.getCarriername());
			entity.setSeatcapacity(entity.getSeatcapacity());
			repository.save(entity);
			return "Flight updated successfully!";
		}
		else {
			throw new FlightNotFoundException("Booking not found for the given id");
		}
	}

	@Override
	public String deleteFlightById(long flightnumber) throws FlightNotFoundException {
		Optional<FlightEntity> entity = repository.findById(flightnumber);
		if(entity.isPresent()) {
			repository.deleteById(flightnumber);
			return "Booking record deleted successfully!";
		}
		else {
			throw new FlightNotFoundException("Flight not found for the given id");
		}
		
	}

	@Override
	public String addFlight(@Valid Flight flight) {
		FlightEntity entity=new FlightEntity();
		entity.setFlightnumber(entity.getFlightnumber());
		entity.setFlightmodel(entity.getFlightmodel());
		entity.setCarriername(entity.getCarriername());
		entity.setSeatcapacity(entity.getSeatcapacity());
		repository.saveAndFlush(entity);	
		String msg = "Flight added successfully with Flight Numeber:"+entity.getFlightnumber();
		return msg;
	}

}
