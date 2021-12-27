package com.flyhigh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flyhigh.model.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
