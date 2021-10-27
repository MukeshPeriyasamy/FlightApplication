package com.flightapp.exception;

public class FlightNotFoundException extends Exception {
	
	private static final long serialVersionUID = 299052614652951705L;
	
	public FlightNotFoundException(String message) {
        super(message);
    }
	
}
