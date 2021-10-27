package com.flightapp.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Flight;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.repositories.FlightRepository;
import com.flightapp.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> findAllFlights(){
		return flightRepository.findAll();	
	}
	
	public Flight saveFlight(Flight flight){
		return flightRepository.save(flight);	
	}
	
	public Flight findFlightByName(String name) throws FlightNotFoundException{
		Flight flightDetails = flightRepository.findByName(name);
		if(null != flightDetails) {
		return flightRepository.findByName(name);
		}
		else {
			throw new FlightNotFoundException("The flight not available");
		}
	}

	public List<Flight> findFlightByAirline(String airline) {
		return flightRepository.findByAirline(airline) ;
	}
	
}
