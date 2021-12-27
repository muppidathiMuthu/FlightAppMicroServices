package com.flyhigh.repository;

import com.flyhigh.model.*;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findByStartDateTimeGreaterThanAndFromPlaceAndToPlace(Timestamp date, String fromPlace, String toPlace);

	List<Flight> findByFromPlaceAndToPlace(String fromPlace, String toPlace);

}
