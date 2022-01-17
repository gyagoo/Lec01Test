package com.gyagoo.test.lec06.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec06.dao.BookingDAO;
import com.gyagoo.test.lec06.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	// select
	public List<Booking> getBooking() {
		return bookingDAO.selectBooking();
	}
	
	// delete
	public int deleteBooking(int id) {
		return bookingDAO.deleteBooking(id);
	}
	
	// insert
	public int addBooking(String name, int headcount, Date date, int day, String phoneNumber, String state) {
		return bookingDAO.insertBooking(name, headcount, day, date, phoneNumber, state);
	}
	
	// inquire
	public Booking inquireBooking(String name, String phoneNumber) {
		return bookingDAO.selectBooking_NamePhone(name, phoneNumber);
	}
	
	// lookup
	// 이름과 전화번호를 통해 조회된 결과를 모두 가져와야 함 -> 여러개
	// 객체 하나만 return 할 것이기 때문에 Booking
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		return bookingDAO.selectBookingbyNamePhoneNumber(name, phoneNumber);
	}
}
