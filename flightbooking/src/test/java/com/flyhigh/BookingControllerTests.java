package com.flyhigh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.flyhigh.controller.BookingController;
import com.flyhigh.service.BookingService;
import com.netflix.discovery.converters.Auto;
import com.flyhigh.model.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTests {
	
	@InjectMocks
	private BookingController bookingController;
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	BookingService bookingService;
	Flight flight;
	//BookingRepository bookingRepository;
	
	@BeforeEach
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
	}

	
	@Test
	public void GetMappingOfSearchFlight() throws Exception {
	    mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.get("/api/booking/search?from=\"Madurai\"&to=\"Chennai\"").
	           contentType(MediaType.APPLICATION_JSON)).
	           andExpect(MockMvcResultMatchers.status().isOk()).
	           andDo(MockMvcResultHandlers.print());
	}

}
