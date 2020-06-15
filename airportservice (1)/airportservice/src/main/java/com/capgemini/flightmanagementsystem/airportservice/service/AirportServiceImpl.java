/****************************************************************************************************************************
 - File Name        : AirportServiceImpl
 - Author           : Raza Hasan
 - Creation Date    : 11-06-2020
 - Description      : This is a service class which contains the business logic of Airport Service
  ****************************************************************************************************************************/ 
package com.capgemini.flightmanagementsystem.airportservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.airportservice.dao.AirportEntity;
import com.capgemini.flightmanagementsystem.airportservice.dao.AirportRepository;
import com.capgemini.flightmanagementsystem.airportservice.exception.AirportNotFoundException;
import com.capgemini.flightmanagementsystem.airportservice.model.Airport;

@Service
public class AirportServiceImpl implements AirportService{
	
	@Autowired
	AirportRepository repository;
	/****************************************************************************************************************************
	- Method Name      : viewAirport
	- Input Parameters : -
	- Return type      : List<Flight>
	- Author           : Raza Hasan
	- Creation Date    : 11-06-2020
	- Description      : Shows all the Airport available.
	 ****************************************************************************************************************************/ 
	@Override
	public List<Airport> viewAirport() {
		List<AirportEntity> entityList=repository.findAll();
		List<Airport> newAirportList = new ArrayList<>();
		for (AirportEntity entity : entityList) {
			Airport airport = new Airport();
			airport.setAirportName(entity.getAirportName());
			airport.setAirportCode(entity.getAirportCode());
			airport.setAirportLocation(entity.getAirportLocation());
			
			newAirportList.add(airport);
	}
		return newAirportList;
	}
	/****************************************************************************************************************************
	- Method Name      : viewFlight
	- Input Parameters : airport code
	- Return type      : Airport Entity
	- Author           : Raza Hasan
	- Creation Date    : 11-06-2020
	- Description      : Shows all the Airport of a gven airport code
	 ****************************************************************************************************************************/ 
	@Override
	public AirportEntity viewAirportById(String airportcode) throws AirportNotFoundException {
		Optional<AirportEntity> entity = repository.findById(airportcode);
		if(entity.isPresent()) {
			return entity.get();
		}
		else {
			throw new AirportNotFoundException("Airport not found for the given code");
		}
	}

}
