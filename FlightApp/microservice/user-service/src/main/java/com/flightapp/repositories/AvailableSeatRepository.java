package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.AvailableSeat;

public interface AvailableSeatRepository extends JpaRepository<AvailableSeat,Integer> {

	AvailableSeat findBySchedule(int scheduleId);

}
