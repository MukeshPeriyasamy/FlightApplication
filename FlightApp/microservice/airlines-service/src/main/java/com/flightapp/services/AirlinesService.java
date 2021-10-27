package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entities.AirlineSchedule;
import com.flightapp.entities.Airlines;
import com.flightapp.entities.Flight;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.models.AvailableSchedule;
import com.flightapp.models.SearchRequest;
import com.flightapp.repositories.AirlinesRepository;

public interface AirlinesService {

	public List<Flight> findAllFlights();
	
	public Flight findFlightByName(String name);
	
	public List<Airlines> findAllAirlines();
	
	public Airlines saveAirline(Airlines airline);
	
	public Airlines findAirlinesByName(String airline);
	
	public List<AirlineSchedule> findAllAirlineSchedule();
	
	public AirlineSchedule saveAirlineSchedule(AirlineSchedule schedule) throws FlightNotFoundException;

	public List<AvailableSchedule> searchAvailableSchedule(SearchRequest request) throws FlightNotFoundException;
	
}
