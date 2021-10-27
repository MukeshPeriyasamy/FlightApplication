package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirlineSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="airline_name")
	private String airlineName;
	@Column(name="flight_name")
	private String flightName;
	@Column(name="start_place")
	private String startPlace;
	@Column(name="end_place")
	private String endPlace;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	@Column(name="schedule_day")
	private String scheduleDay;
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
	public String getScheduleDay() {
		return scheduleDay;
	}
	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
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
	
	public AirlineSchedule(int id, String airlineName, String flightName, String startPlace, String endPlace,
			String startTime, String endTime, String scheduleDay, float price, int availability) {
		this(airlineName, flightName, startPlace, endPlace, startTime, endTime, scheduleDay, price, availability);
		this.id = id;
	}
	
	public AirlineSchedule(String airlineName, String flightName, String startPlace, String endPlace,
			String startTime, String endTime, String scheduleDay, float price, int availability) {
		super();
		this.airlineName = airlineName;
		this.flightName = flightName;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.scheduleDay = scheduleDay;
		this.price = price;
		this.availability = availability;
	}
	
	public AirlineSchedule() {}
	
	@Override
	public String toString() {
		return "AirlineSchedule [id=" + id + ", airlineName=" + airlineName + ", flightName=" + flightName
				+ ", startPlace=" + startPlace + ", endPlace=" + endPlace + ", startTime=" + startTime + ", endTime="
				+ endTime + ", scheduleDay=" + scheduleDay + ", price=" + price + ", availability=" + availability
				+ "]";
	}	

}
