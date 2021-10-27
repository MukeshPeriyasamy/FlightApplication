package com.flightapp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.model.ExceptionMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ExceptionMessage> flightExceptionHandler(FlightNotFoundException e){
		return new ResponseEntity<ExceptionMessage>(
				new ExceptionMessage(500, e.getMessage())
				, HttpStatus.OK);
	}
}
