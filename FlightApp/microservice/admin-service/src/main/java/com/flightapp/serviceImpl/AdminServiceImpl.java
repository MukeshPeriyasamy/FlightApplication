package com.flightapp.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.model.AirlineSchedule;
import com.flightapp.model.Airlines;
import com.flightapp.model.Flight;
import com.flightapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Flight> findAllFlights() {
		ResponseEntity<List<Flight>> response = restTemplate.exchange("http://FLIGHT-SERVICE/all", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Flight>>() {
				});
		return response.getBody();
	}

	public Flight findFlightByName(String name) {
		ResponseEntity<Flight> response = restTemplate.exchange("http://FLIGHT-SERVICE/name/" + name, HttpMethod.GET,
				null, new ParameterizedTypeReference<Flight>() {
				});
		return response.getBody();
	}

	public Flight findFlightByAirline(String airline) {
		ResponseEntity<Flight> response = restTemplate.exchange("http://FLIGHT-SERVICE/airline" + airline,
				HttpMethod.GET, null, new ParameterizedTypeReference<Flight>() {
				});
		return response.getBody();
	}

	@Override
	public Flight saveFlight(Flight flight) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Flight> req = new HttpEntity<>(flight, requestHeaders);
		ResponseEntity<Flight> response = restTemplate.postForEntity("http://FLIGHT-SERVICE/add", req, Flight.class);
		return response.getBody();
	}

	@Override
	public Flight cancelFlight(String name) throws Exception {
		Flight flight = findFlightByName(name);
		if (flight != null && flight.getName() != null) {
			flight.setAvailability(0);
			return saveFlight(flight);
		} else {
			throw new Exception("Flight not available to cancel");
		}
	}

	@Override
	public List<Airlines> findAllAirlines() {
		ResponseEntity<List<Airlines>> response = restTemplate.exchange("http://AIRLINES-SERVICE/all", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Airlines>>() {
				});
		return response.getBody();
	}

	@Override
	public Airlines saveAirline(Airlines airline) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Airlines> req = new HttpEntity<>(airline, requestHeaders);
		ResponseEntity<Airlines> response = restTemplate.postForEntity("http://AIRLINES-SERVICE/add", req,
				Airlines.class);
		return response.getBody();
	}

	@Override
	public Airlines cancelAirline(String name) throws Exception {
		Airlines airline = findAirlinesByName(name);
		if(airline != null) {
		airline.setAvailabilty(0);
		return saveAirline(airline);
		}else {
			throw new Exception("Airline not available to cancel");
		}
	}

	@Override
	public Airlines findAirlinesByName(String name) {
		ResponseEntity<Airlines> response = restTemplate.exchange("http://AIRLINES-SERVICE/name/" + name,
				HttpMethod.GET, null, new ParameterizedTypeReference<Airlines>() {
				});
		return response.getBody();
	}

	@Override
	public List<AirlineSchedule> findAllAirlineSchedule() {
		ResponseEntity<List<AirlineSchedule>> response = restTemplate.exchange("http://AIRLINES-SERVICE/schedules",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AirlineSchedule>>() {
				});
		return response.getBody();
	}

	@Override
	public AirlineSchedule saveAirlineSchedule(AirlineSchedule airlineSchedule) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AirlineSchedule> req = new HttpEntity<>(airlineSchedule, requestHeaders);
		ResponseEntity<AirlineSchedule> response = restTemplate.postForEntity("http://AIRLINES-SERVICE/schedule/add",
				req, AirlineSchedule.class);
		return response.getBody();
	}

}
