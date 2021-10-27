package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.AirlineSchedule;
import com.flightapp.model.Airlines;
import com.flightapp.model.Flight;
import com.flightapp.service.AdminService;

@RestController
public class AdminServiceController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/flights")
	public List<Flight> findAllFlights(){
		return adminService.findAllFlights();
	}
	
	@PostMapping("/flight/add")
	public Flight saveFlight(@RequestBody Flight flight){
		flight.setAvailability(1);
		return adminService.saveFlight(flight);
	}
	
	@GetMapping("/flight/cancel/{name}")
	public Flight cancelFlight(@PathVariable String name) throws Exception{
		return adminService.cancelFlight(name);
	}
	
	@GetMapping("/airlines")
	public List<Airlines> findAllAirlines(){
		return adminService.findAllAirlines();
	}
	
	@PostMapping("/airline/add")
	public Airlines saveAirline(@RequestBody Airlines airline){
		airline.setAvailabilty(1);
		return adminService.saveAirline(airline);
	}
	
	@GetMapping("/airline/{name}")
	public Airlines findAirlineByName(@PathVariable String name){
		return adminService.findAirlinesByName(name);
	}
	
	@GetMapping("/airline/cancel/{name}")
	public Airlines cancelAirline(@PathVariable String name) throws Exception{
		return adminService.cancelAirline(name);
	}
	
	@GetMapping("/schedules")
	public List<AirlineSchedule> findAllAirlineSchedule(){
		return adminService.findAllAirlineSchedule();
	}
	
	@PostMapping("/schedule/add")
	public AirlineSchedule saveAirlineSchedule(@RequestBody AirlineSchedule airlineSchedule){
		return adminService.saveAirlineSchedule(airlineSchedule);
	}
 
}
