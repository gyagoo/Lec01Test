package com.gyagoo.test.lec06;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		Map<String, String>	result = new HashMap<>();
		// 성공 (result:"success")
		// 실패 (result:"fail")
		int count = bookingBO.deleteBooking(id);
		
		if (count == 1) {	// 성공
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/lec06/go_booking_view")
	public String addBookingView() {
		return "lec06/pension/addBooking";
	}
	
	// insert(API)
	@ResponseBody
	@PostMapping("/lec06/go_booking")
	public Map<String, String> addBooking(
			@RequestParam("name") String name,
			@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
			@RequestParam("date") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Map<String, String>	map = new HashMap<>();
		
		int count = bookingBO.addBooking(name, headcount, date, day, phoneNumber, "대기중");
		
		if (count == 1) {	// 성공
			map.put("result", "success");
//			return "success";
		} else {
			map.put("result", "fail");
//			return "fail";
		}
		
		return map;
	}
	@ResponseBody	// 데이터만 저장해서 전달
	@GetMapping("/lec06/inquire_booking")
	public Booking inquireBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.inquireBooking(name, phoneNumber);
		/*
		Map<String, Object> bookingmap = new HashMap<>();
		bookingmap.put("name", name);
		bookingmap.put("date", date);
		bookingmap.put("day", 3);
		bookingmap.put("headcount", headcount);
		bookingmap.put("state", state);
		*/
		return booking;
		
	}
	
	/*
		오답노트
	 	- resultType을 model롤 잡지 않았음
	 	- query 조건문에 AND 빠짐
	 */
	
//	answer
	@ResponseBody
	@GetMapping("/lec06/lookup")
	public Map<String, Object> lookup(@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		
		/*
		하나의 객체를 return할 경우를 가정
		select 결과가 여러개일 경우? 무조건 List(보통 List로 사용)
		api는 responseBody에 담아서 데이터만 전달하는 역할(client)
		ajax(server)와 분리되어 있음
		
		조회 가능한 데이터가 없는 경우 어떤 값들을 전달하는가? 객체는 null
		null일 경우와 아닌 경우를 나누어서 처리하자 ! ! !
		
		- return값이 있는 형태가 이상적이다 -> Map을 통해 처리하자 ! ! !
		
		- 실패든 성공이든 하나의 규격으로 가는 것이 좋다
		*/
		
		Map<String, Object> response = new HashMap<>();
		if(booking == null) {	// 조회된 데이터가 없는 경우
			response.put("result", "fail");
		} else {
			response.put("result", "success");
			// 성공했을 때의 데이터 전달
			response.put("booking", booking);
		}

		return response;
	}
		
//		List<Booking> mybooking = bookingBO.inquireBooking(name, phoneNumber, null, 0, 0, phoneNumber);
//		model.addAttribute("mybooking", mybooking);
//		return "lec06/pension/main";
	
}
