/****************************************************************************************************************************
 - File Name        : FlightServiceImpl
 - Author           : Raza Hasan
 - Creation Date    : 11-06-2020
 - Description      : This is a service class which contains the business logic of Flight Service
  ****************************************************************************************************************************/ 
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
private FlightRepository repository;
//
//@Autowired
//Flight flight;
/****************************************************************************************************************************
- Method Name      : viewFlight
- Input Parameters : -
- Return type      : List<Flight>
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Shows all the Flight available.
 ****************************************************************************************************************************/ 
	@Override
	public List<Flight> viewFlight() {
		List<FlightEntity> entityList=repository.findAll();
		List<Flight> flightList = new ArrayList<>();
		for (FlightEntity entity : entityList) {
		Flight flight = new Flight();
			flight.setFlightNumber(entity.getFlightNumber());
			flight.setFlightModel(entity.getFlightModel());
			flight.setCarrierName(entity.getCarrierName());
			flight.setSeatCapacity(entity.getSeatCapacity());
			
			flightList.add(flight);
	}
		return flightList;
	}
	/****************************************************************************************************************************
	 - Method Name      : viewFlightById
	 - Input Parameters : flightnumber
	 - Return type      : List<Flight>
	 - Author           : Raza Hasan
	 - Creation Date    : 11-06-2020
	 - Description      : Returns a flight with a given flight number.
	  ****************************************************************************************************************************/ 

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

	/****************************************************************************************************************************
	 - Method Name      : updateFlightById
	 - Input Parameters : flightnumber, Flight
	 - Return type      : String
	 - Author           : Raza Hasan
	 - Creation Date    : 11-06-2020
	 - Description      : Updates a flight into the database.
	  ****************************************************************************************************************************/ 
	

	@Override
	public String updateFlightgById(long flightnumber, Flight flight) throws FlightNotFoundException {
		Optional<FlightEntity> optional = repository.findById(flightnumber);
		if(optional.isPresent()) {
			FlightEntity entity = optional.get();
			entity.setFlightNumber(flight.getFlightNumber());
			entity.setFlightModel(flight.getFlightModel());
			entity.setCarrierName(flight.getCarrierName());
			entity.setSeatCapacity(flight.getSeatCapacity());
			repository.save(entity);
			return "Flight updated successfully!";
		}
		else {
			throw new FlightNotFoundException("Flight not found for the given number");
		}
	}
	/****************************************************************************************************************************
	 - Method Name      : deleteFlightgById
	 - Input Parameters : flightnumber
	 - Return type      : String
	 - Author           : Raza Hasan
	 - Creation Date    : 11-06-2020
	 - Description      : Deleting the flight of  given flight number from the database.
	  ****************************************************************************************************************************/ 

	@Override
	public String deleteFlightById(long flightnumber) throws FlightNotFoundException {
		Optional<FlightEntity> entity = repository.findById(flightnumber);
		if(entity.isPresent()) {
			repository.deleteById(flightnumber);
			return "Flight is deleted successfully!";
		}
		else {
			throw new FlightNotFoundException("Flight not found for the given id "+flightnumber);
		}
		
	}
	/****************************************************************************************************************************
	 - Method Name      : addFlight
	 - Input Parameters : Flight
	 - Return type      : String
	 - Author           : Raza Hasan
	 - Creation Date    : 11-06-2020
	 - Description      : Inserting the flight into the database.
	  ****************************************************************************************************************************/ 
	

	@Override
	public String addFlight(@Valid Flight flight) {
		FlightEntity entity=new FlightEntity();
		entity.setFlightNumber(flight.getFlightNumber());
		entity.setFlightModel(flight.getFlightModel());
		entity.setCarrierName(flight.getCarrierName());
		entity.setSeatCapacity(flight.getSeatCapacity());
		repository.saveAndFlush(entity);	
		return "Flight added successfully with Flight Numeber:"+entity.getFlightNumber();
		
	}

}
