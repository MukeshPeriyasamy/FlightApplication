package com.flightapp.models;


public class AvailableSchedule {

	private int id;
	private String airlineName;
	private String flightName;
	private String startPlace;
	private String endPlace;
	private String startTime;
	private String endTime;
	private String journeyDate;
	private float price;
	private int availability;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public AvailableSchedule(String airlineName, String flightName, String startPlace, String endPlace,
			String startTime, String endTime, String journeyDate, float price, int availability) {
		super();
		this.airlineName = airlineName;
		this.flightName = flightName;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.journeyDate = journeyDate;
		this.price = price;
		this.availability = availability;
	}
	
	public AvailableSchedule(int id,String airlineName, String flightName, String startPlace, String endPlace,
			String startTime, String endTime, String journeyDate, float price, int availability) {
		this(airlineName, flightName, startPlace, endPlace, startTime, endTime, journeyDate, price, availability);
		this.id = id;
	}
	
	public AvailableSchedule() {}
	
}
