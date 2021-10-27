package com.flightapp.service;

import java.util.List;

import com.flightapp.model.AirlineSchedule;
import com.flightapp.model.Airlines;
import com.flightapp.model.Flight;

public interface AdminService {
	
	List<Flight> findAllFlights();

	Flight saveFlight(Flight flight);
	
	Flight cancelFlight(String name) throws Exception;

	List<Airlines> findAllAirlines();

	Airlines saveAirline(Airlines airline);
	
	Airlines cancelAirline(String name) throws Exception;

	Airlines findAirlinesByName(String name);

	List<AirlineSchedule> findAllAirlineSchedule();

	AirlineSchedule saveAirlineSchedule(AirlineSchedule airlineSchedule);
	
}
