package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Ticket findByEmail(String email);

}
