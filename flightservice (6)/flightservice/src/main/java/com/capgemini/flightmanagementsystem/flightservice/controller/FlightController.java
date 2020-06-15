/****************************************************************************************************************************
 - File Name        : FlightController
 - Author           : Raza Hasan
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume Flight Services.
  ****************************************************************************************************************************/ 
package com.capgemini.flightmanagementsystem.flightservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.flightservice.dao.FlightEntity;
import com.capgemini.flightmanagementsystem.flightservice.exception.FlightNotFoundException;
import com.capgemini.flightmanagementsystem.flightservice.model.Flight;
import com.capgemini.flightmanagementsystem.flightservice.service.FlightService;

@RestController
public class FlightController {
@Autowired
FlightService service;
/****************************************************************************************************************************
- Method Name      : addFlight
- Input Parameters : Flight
- Return type      : ResponseEntity<String>
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Adding Flight to existing Flights.
-End point URL     : localhost:4568/addFlight
 ****************************************************************************************************************************/ 
@PostMapping("/addFlight")
public ResponseEntity<String> addFlight(@Valid @RequestBody Flight flight) {
	String msg= service.addFlight(flight);
	return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
}
/****************************************************************************************************************************
- Method Name      : viewFlight
- Input Parameters : -
- Return type      : List<Flight>
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Shows all available flights.
-End point URL     : localhost:4568/viewFlight
 ****************************************************************************************************************************/ 
@GetMapping("/viewFlight")
public List<Flight> viewFlight() {
	return service.viewFlight();
}
/****************************************************************************************************************************
- Method Name      : viewFlightById
- Input Parameters : flightnumber
- Return type      : Return flight
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Show  flight of a given flight number.
-End point URL     : localhost:4568/viewFlightById/{flightnumber}
 ****************************************************************************************************************************/ 
@GetMapping("/viewFlightById/{flightnumber}")
public FlightEntity  viewFlightById(@PathVariable("flightnumber")Long flightnumber) throws FlightNotFoundException {
	return service.viewFlightById(flightnumber);
}
/****************************************************************************************************************************
- Method Name      : updateFlightById
- Input Parameters : flightnumber
- Return type      : ResponseEntity<String>
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Updates a flight of a given flight number.
-End point URL     : localhost:4568/updateFlightById/{flightnumber}
 ****************************************************************************************************************************/ 
@PutMapping("/updateFlightById/{flightnumber}")
public ResponseEntity<String> updateFlightById(@PathVariable Long flightnumber, @RequestBody Flight flight) throws FlightNotFoundException {
	return ResponseEntity.ok(service.updateFlightgById(flightnumber,flight));
}
/****************************************************************************************************************************
- Method Name      : deleteFlightById
- Input Parameters : flight number
- Return type      : ResponseEntity<String>
- Author           : Raza Hasan
- Creation Date    : 11-06-2020
- Description      : Deletes a flight of a given flight number
-End point URL     : localhost:4568/deleteFlightById/{flightnumber}
 ****************************************************************************************************************************/ 

@DeleteMapping("/deleteFlightById/{flightnumber}")
public ResponseEntity<String> deleteFlightById(@PathVariable Long flightnumber) throws FlightNotFoundException{
	return ResponseEntity.ok(service.deleteFlightById(flightnumber)); 
}
}
