package com.flyhigh.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDetails {

	@JsonProperty("emailId")
	String emailId;
	@JsonProperty("pnr")
	String pnr;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public BookingDetails(String emailId, String pnr) {
		super();
		this.emailId = emailId;
		this.pnr = pnr;
	}
	
	public BookingDetails() {
		
	}
	
}
