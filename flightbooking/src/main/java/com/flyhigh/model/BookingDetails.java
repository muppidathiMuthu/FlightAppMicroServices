package com.flyhigh.model;

public class BookingDetails {

	String emailId;
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
	
	
	
}
