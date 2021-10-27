package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.Flight;
import com.flightapp.exception.FlightNotFoundException;


public interface FlightService {
	
	public List<Flight> findAllFlights();
	
	public Flight saveFlight(Flight flight);
	
	public Flight findFlightByName(String name) throws FlightNotFoundException;
	
	public List<Flight> findFlightByAirline(String airline);
	
}
