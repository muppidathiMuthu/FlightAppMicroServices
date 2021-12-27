package com.flyhigh.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class InventoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	InventoryService inventoryService;

	@PostMapping("/airline")
	public Long addAirline(@RequestBody Airline airline){
		logger.info("In addAirline method of Booking InventoryController");
		return inventoryService.addAirline(airline);
	}
	
	@PutMapping("/airline")
	public Long blockAirline(@RequestParam("id") Long airlineId) throws Exception{
		logger.info("In blockAirline method of Booking InventoryController");
		return inventoryService.blockAirline(airlineId);
	}
	
	@PostMapping("/flight")
	public Long addFlight(@RequestBody Flight flight){
		logger.info("In addFlight method of Booking InventoryController");
		return inventoryService.addFlight(flight);
	}
}
