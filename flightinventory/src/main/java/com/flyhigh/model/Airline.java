package com.flyhigh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String airlineName;
	String airlineContact;
	String airlineAddress;
	boolean isBlocked;
	
	@OneToMany(mappedBy = "airline",fetch = FetchType.LAZY)
	Set<Flight> flights;

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the airlineName
	 */
	public String getAirlineName() {
		return airlineName;
	}
	/**
	 * @param airlineName the airlineName to set
	 */
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	/**
	 * @return the airlineContact
	 */
	public String getAirlineContact() {
		return airlineContact;
	}
	/**
	 * @param airlineContact the airlineContact to set
	 */
	public void setAirlineContact(String airlineContact) {
		this.airlineContact = airlineContact;
	}
	/**
	 * @return the airlineAddress
	 */
	public String getAirlineAddress() {
		return airlineAddress;
	}
	/**
	 * @param airlineAddress the airlineAddress to set
	 */
	public void setAirlineAddress(String airlineAddress) {
		this.airlineAddress = airlineAddress;
	}
	/**
	 * @return the isBlocked
	 */
	public boolean isBlocked() {
		return isBlocked;
	}
	/**
	 * @param isBlocked the isBlocked to set
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
}
