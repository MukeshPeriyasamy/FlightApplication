package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.AirlineSchedule;
import com.flightapp.models.AvailableSchedule;

public interface AirlineScheduleRepository extends JpaRepository<AirlineSchedule, Integer> {

	List<AirlineSchedule> findByStartPlaceAndEndPlace(String startPlace, String endPlace);

}
