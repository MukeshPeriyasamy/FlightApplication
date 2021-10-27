package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Flight findByName(String name);
	
	List<Flight> findByAirline(String airline);

}
