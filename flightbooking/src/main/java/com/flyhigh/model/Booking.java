/**
 * 
 */
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

/**
 * @author muthu
 *
 */
@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String emailId;

	String gender;
	int age;
	int noOfPassenger;

	/*
	 * @OneToMany(mappedBy = "booking",fetch = FetchType.EAGER,cascade =
	 * CascadeType.ALL) Set<Passenger> passengers;
	 */

	Boolean isMeal;
	Boolean isVeg;

	String pnr;
	Boolean isCancelled;

	int flightNumber;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the flightNumber
	 */
	public int getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the isMeal
	 */
	public Boolean getIsMeal() {
		return isMeal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the passenger
	 */
	/*
	 * public Set<Passenger> getPassengers() { return passengers; }
	 *//**
		 * @param passenger the passenger to set
		 *//*
			 * public void setPassengers(Set<Passenger> passengers) { this.passengers =
			 * passengers; }
			 */
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	/**
	 * @param isMeal the isMeal to set
	 */
	public void setIsMeal(Boolean isMeal) {
		this.isMeal = isMeal;
	}

	/**
	 * @return the isVeg
	 */
	public Boolean getIsVeg() {
		return isVeg;
	}

	/**
	 * @param isVeg the isVeg to set
	 */
	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public Booking(Long id, String name, String emailId, Set<Passenger> passenger, Boolean isMeal, Boolean isVeg,
			String pnr, Boolean isCancelled, int flightId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		//this.passengers = passenger;
		this.isMeal = isMeal;
		this.isVeg = isVeg;
		this.pnr = pnr;
		this.isCancelled = isCancelled;
		this.flightNumber = flightNumber;
	}

	
	public Booking(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}

	public Booking(String name, String emailId, String pnr) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.pnr = pnr;
	}

	public Booking() {

	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", name=" + name + ", emailId=" + emailId 
				+ ", isMeal=" + isMeal + ", isVeg=" + isVeg + ", pnr=" + pnr + ", isCancelled=" + isCancelled
				+ ", flightId=" + flightNumber + "]";
	}

}
