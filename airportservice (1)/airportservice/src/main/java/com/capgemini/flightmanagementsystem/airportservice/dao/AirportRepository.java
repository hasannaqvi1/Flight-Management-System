package com.capgemini.flightmanagementsystem.airportservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, String> {

}