package com.flightapp.exception;

public class FlightNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	 public FlightNotFoundException() {}
	 
	 public FlightNotFoundException(String message) {
		 super(message);
	 }

}
