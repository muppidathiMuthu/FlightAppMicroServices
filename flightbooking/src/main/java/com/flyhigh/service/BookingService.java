package com.flyhigh.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.flyhigh.model.Booking;
import com.flyhigh.model.BookingDetails;
import com.flyhigh.model.Flight;
import com.flyhigh.model.Passenger;
import com.flyhigh.repository.BookingRepository;
import com.flyhigh.repository.FlightRepository;
import com.flyhigh.util.FlightException;

@Service
public class BookingService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private KafkaTemplate<String, BookingDetails> kafkaTemplate;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Flight> searchFlight(Timestamp date, String fromPlace, String toPlace) throws FlightException, Exception {
		List<Flight> flights = new ArrayList<Flight>();
		logger.info("In searchFlight method of Booking service");
		try {
			if(fromPlace!=null && toPlace!=null && date != null) {
				flights = flightRepository.findByStartDateTimeGreaterThanAndFromPlaceAndToPlace(date, fromPlace, toPlace);
			}else if(fromPlace!=null && toPlace!=null) {
				flights = flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);
			}else {
				flights = flightRepository.findAll();
			}
		}catch(Exception ex) {
			logger.error("Error while searchFlight in Bookingservice {}", ex);
			throw ex;
		}
		if(flights == null) {
			throw new FlightException("No flights found");
		}
		return flights;
		
	}

	
	public Booking bookFlight(Booking booking) throws Exception {
		logger.info("In bookFlight method of Booking service");
		try {
			String pnr = generatePNR();
			booking.setPnr(pnr);
			/*
			 * Set<Passenger> passengers = booking.getPassengers();
			 * passengers.forEach(passenger -> passenger.setBooking(booking));
			 */
			bookingRepository.save(booking);
			//kafkaTemplate.send("booking_details", new BookingDetails(booking.getEmailId(),booking.getPnr()));
			return booking;
		}catch(Exception ex) {
			logger.error("Error while bookFlight in Bookingservice {}", ex);
			throw ex;
		}
	}
	
	private String generatePNR() throws Exception {
		logger.info("In generatePNR method of Booking service");
		try{
			int id = bookingRepository.getMaxId()+1;
			String pnr = String.format("%03d", id);
			return pnr;
		}catch(Exception ex) {
			logger.error("Error while generatePNR in Bookingservice {}", ex);
			throw ex;
		}
		
	}


	public List<Booking> getTicketByMail(String emailId) throws Exception {
		logger.info("In getTicketByMail method of Booking service");
		try {
			return bookingRepository.findByEmailIdAndIsCancelledFalse(emailId);
		}catch(Exception ex) {
			logger.error("Error while getTicketByMail in Bookingservice {}", ex);
			throw ex;
		}
		
	}
	
	public List<Booking> getTicketByPnr(String pnr) throws Exception {
		logger.info("In getTicketByPnr method of Booking service");
		try {
			List<Booking> bookingList = new ArrayList<Booking>();
			bookingList.add(bookingRepository.findByPnrAndIsCancelledFalse(pnr));
			return bookingList;	
		}catch(Exception ex) {
			logger.error("Error while getTicketByPnr in Bookingservice {}", ex);
			throw ex;
		}
		
	}
	
	public Long cancelTicketByPnr(String pnr) throws Exception {
		logger.info("In cancelTicketByPnr method of Booking service");
		try {
			System.out.println("The PNR vaue here is ------ "+pnr);
			Booking	booking = bookingRepository.findByPnrAndIsCancelledFalse(pnr);
			booking.setIsCancelled(true);
			return bookingRepository.save(booking).getId();
		}catch(Exception ex) {
			logger.error("Error while cancelTicketByPnr in Bookingservice {}", ex);
			throw ex;
		}
		
	}
}
