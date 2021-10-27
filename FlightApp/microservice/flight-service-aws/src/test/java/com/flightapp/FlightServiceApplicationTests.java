package com.flightapp;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightapp.entities.Flight;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.repositories.FlightRepository;
import com.flightapp.services.FlightService;

@SpringBootTest
class FlightServiceApplicationTests {

	@Autowired
	private FlightService flightService;

	@MockBean
	private FlightRepository flightRepo;

	@Test
	public void shouldGetAllFlights() {

		Mockito.when(flightRepo.findAll()).thenReturn(
				Arrays.asList(new Flight(1, "ind101", 60, 1, "Indigo"), new Flight(2, "ind102", 80, 1, "Indigo")));

		List<Flight> flights = flightService.findAllFlights();
		System.out.println(flights);
		Assertions.assertTrue(flights.size() > 0);
	}

	@Test
	public void shouldGetFlightByAirline() {

		Mockito.when(flightRepo.findByAirline("Indigo")).thenReturn(
				Arrays.asList(new Flight(1, "ind101", 60, 1, "Indigo"), new Flight(2, "ind102", 80, 1, "Indigo")));

		List<Flight> flights = flightService.findFlightByAirline("Indigo");
		System.out.println(flights);
		Assertions.assertTrue(flights.size() > 0);
	}

	@Test
	public void shouldSaveFlight() {

		Mockito.when(flightRepo.save(Mockito.any()))
				.thenReturn(new Flight(1, "ind101", 60, 1, "Indigo"));

		Flight flight = flightService.saveFlight(Mockito.any());
		System.out.println(flight);
		Assertions.assertNotNull(flight);
	}

	@Test
	public void shouldGetFlightByName() {

		Mockito.when(flightRepo.findByName("ind101")).thenReturn(new Flight(1, "ind101", 60, 1, "Indigo"));

		Flight flight = null;
		try {
			flight = flightService.findFlightByName("ind101");
		} catch (FlightNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(flight);
		Assertions.assertNotNull(flight);
	}
}
