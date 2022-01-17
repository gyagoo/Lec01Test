package com.gyagoo.test.lec06.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyagoo.test.lec06.model.Booking;

@Repository
public interface BookingDAO {
	
	public List<Booking> selectBooking();			// select
	public int deleteBooking(@Param("id") int id);	// delete
	public int insertBooking(
			@Param("name") String name,
			@Param("headcount") int headcount,
			@Param("day") int day,
			@Param("date") Date date,
			@Param("phoneNumber") String phoneNumber,
			@Param("state") String state);
	public Booking selectBooking_NamePhone(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
	
	public Booking selectBookingbyNamePhoneNumber(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}
