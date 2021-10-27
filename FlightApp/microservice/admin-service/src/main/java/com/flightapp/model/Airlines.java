package com.flightapp.model;

public class Airlines {
	
	private int id;
	private String name;
	private String contactNumber;
	private String contactAddress;
	private int availabilty;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public int getAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(int availabilty) {
		this.availabilty = availabilty;
	}
	
	
	public Airlines(int id, String name, String contactNumber, String contactAddress, int availabilty) {
		this(name, contactNumber, contactAddress, availabilty);
		this.id = id;
	}
	
	public Airlines(String name, String contactNumber, String contactAddress, int availabilty) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.contactAddress = contactAddress;
		this.availabilty = availabilty;
	}

	public Airlines() {}
}
