package com.flyhigh.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flyhigh.model.Booking;
import com.flyhigh.model.Flight;
import com.flyhigh.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/search")
	public List<Flight> SearchFlight(@RequestParam(name="date",required=false) Timestamp date, @RequestParam("from") String fromPlace, @RequestParam("to") String toPlace) throws Exception {
		logger.info("In SearchFlight method of Booking controller");
		return bookingService.searchFlight(date, fromPlace, toPlace);
	}
	
	@PostMapping("/booking")
	public String bookFlight(@RequestBody Booking booking) throws Exception{
		logger.info("In bookFlight method of Booking controller");
		return bookingService.bookFlight(booking);	
	}
	
	@GetMapping("/ticket/email")
	public List<Booking> getTicketByMail(@RequestParam("emailId") String emailId) throws Exception{
		logger.info("In getTicketByMail method of Booking controller");
		return bookingService.getTicketByMail(emailId);
		
	}
	
	@GetMapping("/ticket/pnr")
	public Booking getTicketBypnr(@RequestParam("pnr") String pnr) throws Exception{
		logger.info("In getTicketBypnr method of Booking controller");
		return bookingService.getTicketByPnr(pnr);		
	}
	
	@PutMapping("/cancel/pnr")
	public Long cancelTicketBypnr(@RequestParam("pnr") String pnr) throws Exception{
		logger.info("In Cancelticketbypnr method of Booking controller");
		return bookingService.cancelTicketByPnr(pnr);
	}
}
