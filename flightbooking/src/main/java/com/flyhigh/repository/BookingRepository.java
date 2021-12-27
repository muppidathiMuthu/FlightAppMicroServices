package com.flyhigh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flyhigh.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query(value = "select max(id) FROM Booking")
	public int getMaxId();

	public List<Booking> findByEmailIdAndIsCancelledFalse(String emailId);

	public Booking findByPnrAndIsCancelledFalse(String pnr); 

}
