package com.flyhigh;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flyhigh.model.Booking;
import com.flyhigh.model.Flight;
import com.flyhigh.repository.BookingRepository;
import com.flyhigh.repository.FlightRepository;
import com.flyhigh.service.BookingService;
import com.flyhigh.util.FlightException;

@SpringBootTest
class FlightbookingApplicationTests {

	@Autowired
	BookingService bookingService;
	
	@MockBean
	FlightRepository flightRepository;
	
	@MockBean
	BookingRepository bookingRepository;
	
	@Test
	public void searchFlightTest() {
		String fromPlace = "Madurai";
		String toPlace = "Chennai";
		
		List<Flight> flights = new ArrayList<Flight>();
		Flight flight = new Flight("Madurai","Chennai");
		flights.add(flight);
		
		Mockito.when(flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace)).thenReturn(flights);
		try {
			Flight flightToTest = bookingService.searchFlight(null, "Madurai", "Chennai").get(0);
			
			Assertions.assertNotNull(flightToTest);
			Assertions.assertEquals(flightToTest.getFromPlace(), "Madurai");
		} catch (FlightException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void getBookingByEmailTest() {
		String name = "Test";
		String emailId = "test@mail.com";
		
		List<Booking> bookings = new ArrayList<Booking>();
		Booking booking = new Booking("Test","test@mail.com");
		bookings.add(booking);
		
		Mockito.when(bookingRepository.findByEmailIdAndIsCancelledFalse(emailId)).thenReturn(bookings);
		try {
			Booking bookingToTest = bookingService.getTicketByMail(emailId).get(0);
			
			Assertions.assertNotNull(bookingToTest);
			Assertions.assertEquals(bookingToTest.getName(),name);
		} catch (FlightException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void getBookingByPnrTest() {
		String name = "Test";
		String emailId = "test@mail.com";
		String pnr = "#001";
	
		
		Mockito.when(bookingRepository.findByPnrAndIsCancelledFalse(pnr)).thenReturn( new Booking("Test","test@mail.com","#001"));
		try {
			Booking bookingToTest = bookingService.getTicketByMail(emailId).get(0);
			
			Assertions.assertNotNull(bookingToTest);
			Assertions.assertEquals(bookingToTest.getName(),name);
			Assertions.assertEquals(bookingToTest.getPnr(),pnr);

		} catch (FlightException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Test
	public void bookFlightTest() {
		String name = "Test";
		String emailId = "test@mail.com";
		String pnr = "#001";
		
		Booking booking = new Booking();
		booking.setPnr("#001");
		
		Mockito.when(bookingRepository.save(new Booking())).thenReturn(booking);
		try {
			String bookingPnr = bookingService.bookFlight(new Booking()).getPnr();
			
			Assertions.assertNotNull(bookingPnr);

		} catch (FlightException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
