package com.flightapp.userservices;

import java.util.List;

import com.flightapp.entities.Passenger;
import com.flightapp.entities.Ticket;
import com.flightapp.models.AvailableSchedule;
import com.flightapp.models.FlightTicket;
import com.flightapp.models.SearchRequest;

public interface UserService {

	FlightTicket bookTicket(FlightTicket ticket);

	FlightTicket cancelTicket(FlightTicket ticket);
	
	FlightTicket getTicketById(long ticketId);

	FlightTicket getTicketByEmail(String email);

	List<AvailableSchedule> searchTicket(SearchRequest request);

}
