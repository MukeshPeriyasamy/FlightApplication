package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.AirlineSchedule;
import com.flightapp.entities.Airlines;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.models.AvailableSchedule;
import com.flightapp.models.SearchRequest;
import com.flightapp.services.AirlinesService;

@RestController
public class AirlinesController {

	@Autowired
	private AirlinesService airlinesService;
	
	@GetMapping("/all")
	public List<Airlines> findAllAirlines(){
		return airlinesService.findAllAirlines();
	}
	
	
	@PostMapping("/add")
	public Airlines saveAirline(@RequestBody Airlines airline){
		return airlinesService.saveAirline(airline);
	}
	
	@GetMapping("/name/{name}")
	public Airlines findAirlineByName(@PathVariable String name){
		return airlinesService.findAirlinesByName(name);
	}
	
	
	@GetMapping("/schedules")
	public List<AirlineSchedule> findAllAirlineSchedule(){
		return airlinesService.findAllAirlineSchedule();
	}
	
	@PostMapping("/schedule/add")
	public AirlineSchedule saveAirlineSchedule(@RequestBody AirlineSchedule airlineSchedule) throws FlightNotFoundException{
		return airlinesService.saveAirlineSchedule(airlineSchedule);
	}
	
	@PostMapping("/searchavailability")
	public List<AvailableSchedule> searchAvailableSchedule(@RequestBody SearchRequest request) throws FlightNotFoundException{
		return airlinesService.searchAvailableSchedule(request);
	}
	
}
