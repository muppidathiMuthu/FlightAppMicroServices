package com.flyhigh.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyhigh.model.Airline;
import com.flyhigh.model.Flight;
import com.flyhigh.repository.AirlineRepository;
import com.flyhigh.repository.FlightRepository;

@Service
public class InventoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	FlightRepository flightReposiory;
	
	public Long addAirline(Airline airline) {
		logger.info("In addAirline method of InventoryService");
		try {
			return airlineRepository.save(airline).getId();
		}catch(Exception ex) {
			logger.error("Error while addAirline in InventoryService {}", ex);
			throw ex;
		}
	}
	
	public Long blockAirline(Long id) throws Exception{
		logger.info("In blockAirline method of InventoryService");
		try{
			Optional<Airline> airlineObject = airlineRepository.findById(id);
			airlineObject.get().setBlocked(true);
			return airlineRepository.save(airlineObject.get()).getId();
		}catch(Exception ex) {
			logger.error("Error while blockAirline in InventoryService {}", ex);
			throw ex;
		}
		
	}
	
	public Long addFlight(Flight flight) {
		logger.info("In addFlight method of InventoryService");
		try {
			return flightReposiory.save(flight).getId();
		}catch(Exception ex) {
			logger.error("Error while addFlight in InventoryService {}", ex);
			throw ex;
		}
	}

}
