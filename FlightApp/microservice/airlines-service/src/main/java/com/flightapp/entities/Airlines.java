package com.flightapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Airlines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String name;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="contact_address")
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

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber
				+ ", contactAddress=" + contactAddress + ", availabilty=" + availabilty + "]";
	}
	
	
	
	
	
}
