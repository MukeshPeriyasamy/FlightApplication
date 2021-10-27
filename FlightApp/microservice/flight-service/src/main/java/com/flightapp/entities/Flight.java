package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String name;
	private int capacity;
	private int availability;
	private String airline;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	public Flight(int id, String name, int capacity, int availability,String airline ) {
		this(name, capacity, availability,airline);
		this.id = id;
	}
	
	public Flight(String name, int capacity, int availability,String airline ) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.availability = availability;
		this.airline = airline;
	}
	
	public Flight() {}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", capacity=" + capacity + ", availability="
				+ availability + ", airline=" + airline + "]";
	}
}
