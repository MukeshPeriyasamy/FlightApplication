package com.flightapp.serviceimpl;

import java.util.ArrayList;
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
import com.flightapp.repositories.AirlineScheduleRepository;
import com.flightapp.repositories.AirlinesRepository;
import com.flightapp.services.AirlinesService;

@Service
public class AirlinesServiceImpl implements AirlinesService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AirlinesRepository airlinesRepository;

	@Autowired
	private AirlineScheduleRepository airlineScheduleRepository;

	public List<Flight> findAllFlights() {
		ResponseEntity<List<Flight>> response = restTemplate.exchange("http://FLIGHT-SERVICE/all ", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Flight>>() {
				});
		return response.getBody();
	}

	public Flight findFlightByName(String name) {
		ResponseEntity<Flight> response = restTemplate.exchange("http://FLIGHT-SERVICE/name/ " + name, HttpMethod.GET,
				null, new ParameterizedTypeReference<Flight>() {
				});
		return response.getBody();
	}

	public Flight findFlightByAirline(String airline) {
		ResponseEntity<Flight> response = restTemplate.exchange("http://FLIGHT-SERVICE/airline/ " + airline,
				HttpMethod.GET, null, new ParameterizedTypeReference<Flight>() {
				});
		return response.getBody();
	}

	public List<Airlines> findAllAirlines() {
		return airlinesRepository.findAll();
	}

	public Airlines saveAirline(Airlines airline) {
		return airlinesRepository.save(airline);
	}

	public Airlines findAirlinesByName(String airline) {
		return airlinesRepository.findByName(airline);
	}

	public List<AirlineSchedule> findAllAirlineSchedule() {
		return airlineScheduleRepository.findAll();
	}

	public AirlineSchedule saveAirlineSchedule(AirlineSchedule schedule) throws FlightNotFoundException {
		if (findFlightByName(schedule.getFlightName()).getAvailability() == 1) {
			return airlineScheduleRepository.save(schedule);
		} else {
			throw new FlightNotFoundException("The flight not available to update the schedule");
		}
	}

	@Override
	public List<AvailableSchedule> searchAvailableSchedule(SearchRequest request) throws FlightNotFoundException {
		List<AirlineSchedule> schedule = airlineScheduleRepository.findByStartPlaceAndEndPlace(request.getStartPlace(),
				request.getEndPlace());
		if (!schedule.isEmpty()) {
			List<AvailableSchedule> availSchedule = new ArrayList<>();
			schedule.stream().forEach(sc -> {
				Airlines airline = findAirlinesByName(sc.getAirlineName());
				Flight flight = findFlightByName(sc.getFlightName());
				if ((airline != null && airline.getAvailabilty() == 1)
						&& (flight != null && flight.getAvailability() == 1)) {
					availSchedule.add(new AvailableSchedule(sc.getId(),sc.getAirlineName(), sc.getFlightName(), sc.getStartPlace(),
							sc.getEndPlace(), sc.getStartTime(), sc.getEndTime(), request.getJourneyDate(),
							sc.getPrice(), sc.getAvailability()));
				}
			});
			return availSchedule;
		} else {
			throw new FlightNotFoundException("The flight not available");
		}
	}

}
