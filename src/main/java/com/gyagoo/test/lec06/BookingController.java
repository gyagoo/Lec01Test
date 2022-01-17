package com.gyagoo.test.lec06;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.test.lec06.bo.BookingBO;
import com.gyagoo.test.lec06.model.Booking;

@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/lec06/booking_main")
	public String pensionView() {
		return "lec06/pension/main";
	}
	// select
	@GetMapping("/lec06/booking_list")
	public String getBooking(Model model) {
		
		List<Booking> bookinglist = bookingBO.getBooking();
		model.addAttribute("bookinglist", bookinglist);
		
		return "lec06/pension/booking_list";
	}
	
	// delete
	@ResponseBody
	@GetMapping("/lec06/delete_booking")
	public String deleteBooking(@RequestParam("id") int id) {
		int count = bookingBO.deleteBooking(id);
		
		if (count == 0) {	// 실패
			return "fail";
		} else {
			return "success";
		}
	}
	
	@GetMapping("/lec06/go_booking_view")
	public String addBookingView() {
		return "lec06/pension/addBooking";
	}
	
	// insert(API)
	@ResponseBody
	@PostMapping("/lec06/go_booking")
	public String addBooking(
			@RequestParam("name") String name,
			@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
			@RequestParam("date") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		int count = bookingBO.addBooking(name, headcount, date, day, phoneNumber, "대기중");
		
		if (count == 1) {	// 성공
			return "success";
		} else {
			return "fail";
		}
	}
	
	@GetMapping("/lec06/inquire_booking")
	public String inquireBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber, Model model) {
		List<Booking> mybooking = bookingBO.inquireBooking(name, phoneNumber);
		model.addAttribute("mybooking", mybooking);
		return "lec06/pension/main";
	}
}
