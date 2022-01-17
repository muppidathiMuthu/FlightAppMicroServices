package com.flyhigh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flyhigh.model.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

	List<Airline> findByIsBlockedFalse();

}
