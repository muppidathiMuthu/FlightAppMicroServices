package com.flyhigh.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flyhigh.model.Airline;
import com.flyhigh.model.Flight;
import com.flyhigh.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin
public class InventoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	InventoryService inventoryService;
	
	@CrossOrigin
	@GetMapping("/allflights")
	public List<Flight> getAllFlights(){
		logger.info("In addAirline method of Booking InventoryController");
		return inventoryService.getAllFlights();
	}
	
	@GetMapping("/airline")
	public List<Airline> getAllAirline(){
		logger.info("In addAirline method of Booking InventoryController");
		return inventoryService.getAllAirline();
	}

	@PostMapping("/airline")
	public Long addAirline(@RequestBody Airline airline){
		logger.info("In addAirline method of Booking InventoryController");
		return inventoryService.addAirline(airline);
	}
	
	@PutMapping("/airline/{id}")
	public Long blockAirline(@PathVariable("id") Long airlineId) throws Exception{
		logger.info("In blockAirline method of Booking InventoryController");
		return inventoryService.blockAirline(airlineId);
	}
	
	@PostMapping("/flight")
	public Long addFlight(@RequestBody Flight flight){
		logger.info("In addFlight method of Booking InventoryController");
		return inventoryService.addFlight(flight);
	}
}
