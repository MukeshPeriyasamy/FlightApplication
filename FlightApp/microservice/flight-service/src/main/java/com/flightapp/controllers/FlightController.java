package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Flight;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.services.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("/all")
	public List<Flight> findAllFlights(){
		return flightService.findAllFlights();	
	}

	
	@PostMapping("/add")
	public Flight saveFlight(@RequestBody Flight flight){
		return flightService.saveFlight(flight);	
	}
	
	@GetMapping("/name/{flightName}")
	public Flight findFlightByName(@PathVariable String flightName) throws FlightNotFoundException{
		return flightService.findFlightByName(flightName);	
	}
	
	@GetMapping("/airline/{name}")
	public List<Flight> findFlightByAirline(@PathVariable String name){
		return flightService.findFlightByAirline(name);	
	}
	

}
