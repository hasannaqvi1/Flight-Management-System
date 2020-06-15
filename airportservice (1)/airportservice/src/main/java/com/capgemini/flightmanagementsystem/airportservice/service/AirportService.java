package com.capgemini.flightmanagementsystem.airportservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.airportservice.dao.AirportEntity;
import com.capgemini.flightmanagementsystem.airportservice.exception.AirportNotFoundException;
import com.capgemini.flightmanagementsystem.airportservice.model.*;

@Service
public interface AirportService {
	public List<Airport> viewAirport();
	public AirportEntity viewAirportById(String airportcode) throws AirportNotFoundException;
}
