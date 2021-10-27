package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Airlines;

public interface AirlinesRepository extends JpaRepository<Airlines, Integer> {

	Airlines findByName(String airline);

}
