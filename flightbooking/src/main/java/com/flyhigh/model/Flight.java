package com.flyhigh.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String flightNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id") 
	@JsonIgnore
	private Airline airline;
	
	
	String fromPlace;
	String toPlace;
	Timestamp startDateTime;
	Timestamp endDateTime;
	String scheduledDays;
	String Instrument;
	int buisnessSeats;
	int nonBuisnessSeats;
	Double ticketCost;
	
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
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	/**
	 * @return the fromPlace
	 */
	public String getFromPlace() {
		return fromPlace;
	}
	/**
	 * @param fromPlace the fromPlace to set
	 */
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	/**
	 * @return the toPlace
	 */
	public String getToPlace() {
		return toPlace;
	}
	/**
	 * @param toPlace the toPlace to set
	 */
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	/**
	 * @return the startDateTime
	 */
	public Timestamp getStartDateTime() {
		return startDateTime;
	}
	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}
	/**
	 * @return the endDateTime
	 */
	public Timestamp getEndDateTime() {
		return endDateTime;
	}
	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}
	/**
	 * @return the scheduledDays
	 */
	public String getScheduledDays() {
		return scheduledDays;
	}
	/**
	 * @param scheduledDays the scheduledDays to set
	 */
	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
	}
	/**
	 * @return the instrument
	 */
	public String getInstrument() {
		return Instrument;
	}
	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(String instrument) {
		Instrument = instrument;
	}
	/**
	 * @return the buisnessSeats
	 */
	public int getBuisnessSeats() {
		return buisnessSeats;
	}
	/**
	 * @param buisnessSeats the buisnessSeats to set
	 */
	public void setBuisnessSeats(int buisnessSeats) {
		this.buisnessSeats = buisnessSeats;
	}
	/**
	 * @return the nonBuisnessSeats
	 */
	public int getNonBuisnessSeats() {
		return nonBuisnessSeats;
	}
	/**
	 * @param nonBuisnessSeats the nonBuisnessSeats to set
	 */
	public void setNonBuisnessSeats(int nonBuisnessSeats) {
		this.nonBuisnessSeats = nonBuisnessSeats;
	}
	/**
	 * @return the ticketCost
	 */
	public Double getTicketCost() {
		return ticketCost;
	}
	/**
	 * @param ticketCost the ticketCost to set
	 */
	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}
	/**
	 * @return the airline
	 */
	public Airline getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Flight(Long id, String flightNumber, Airline airline, String fromPlace, String toPlace,
			Timestamp startDateTime, Timestamp endDateTime, String scheduledDays, String instrument, int buisnessSeats,
			int nonBuisnessSeats, Double ticketCost) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduledDays = scheduledDays;
		Instrument = instrument;
		this.buisnessSeats = buisnessSeats;
		this.nonBuisnessSeats = nonBuisnessSeats;
		this.ticketCost = ticketCost;
	}
	
	public Flight() {
		
	}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", airline=" + airline + ", fromPlace="
				+ fromPlace + ", toPlace=" + toPlace + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", scheduledDays=" + scheduledDays + ", Instrument=" + Instrument + ", buisnessSeats="
				+ buisnessSeats + ", nonBuisnessSeats=" + nonBuisnessSeats + ", ticketCost=" + ticketCost + "]";
	}
	
	
}
