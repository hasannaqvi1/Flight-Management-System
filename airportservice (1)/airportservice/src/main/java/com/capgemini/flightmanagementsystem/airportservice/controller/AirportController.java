package com.capgemini.flightmanagementsystem.airportservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.airportservice.dao.AirportEntity;
import com.capgemini.flightmanagementsystem.airportservice.exception.AirportNotFoundException;
import com.capgemini.flightmanagementsystem.airportservice.model.Airport;
import com.capgemini.flightmanagementsystem.airportservice.service.AirportService;

@RestController
public class AirportController {
	@Autowired
	AirportService service;
	
	/****************************************************************************************************************************
	 - Method Name      : viewAirort
	 - Input Parameters : -
	 - Return type      : Return all airport available
	 - Author           : Raza Hasan
	 - Creation Date    : 14-06-2020
	 - Description      : Shows all available airport
	 -End point URL     : localhost:4569/viewAirport
	  ****************************************************************************************************************************/ 

	@GetMapping("/viewAirport")
	public List<Airport> viewAirport() {
		return service.viewAirport();
	}
	/****************************************************************************************************************************
	 - Method Name      : viewAirortById
	 - Input Parameters : airport code
	 - Return type      : Return airport of a given airport code
	 - Author           : Raza Hasan
	 - Creation Date    : 14-06-2020
	 - Description      : Shows airport of a given airport code
	 -End point URL     : localhost:4569/viewAirportById
	  ****************************************************************************************************************************/ 

	
	@GetMapping("/viewAirportById/{airportcode}")
	public AirportEntity  viewAirportById(@PathVariable("airportcode")String airportcode) throws AirportNotFoundException {
		return service.viewAirportById(airportcode);
	}
}
