package com.flyhigh.model;

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
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String gender;
	int age;
	int seatNo;

	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "booking_id") 
	 @JsonIgnore
	 private Booking booking;
	 

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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the seatNo
	 */
	public int getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Passenger(Long id, String name, String gender, int age, int seatNo, Booking booking) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNo = seatNo;
		this.booking = booking;
	}

	/**
	 * @return the booking
	 */
	
	public Passenger() {
		
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", seatNo=" + seatNo
				+ ", booking=" + booking + "]";
	}
	
	

}
