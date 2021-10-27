package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	List<Passenger> findByTicketId(long ticketId);

}
