package com.gyagoo.test.lec02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.test.lec02.bo.RealEstateBO;
import com.gyagoo.test.lec02.model.RealEstate;

@RestController
@RequestMapping("/lec03/test01")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public RealEstate test01_1(@RequestParam(value="id", defaultValue="5") int id) {
		return realEstateBO.getRealEstate(id);
	}
	// 디폴트 값은 22였으나 테이블에 값이 존재하지 않아 5로 지정
	
	@RequestMapping("/2")
	public List<RealEstate> test01_2(@RequestParam(value="rentPrice", defaultValue="90") int rentPrice) {
		return realEstateBO.getRentPrice(rentPrice);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
	@RequestMapping("/3")
	public List<RealEstate> test01_3(
			@RequestParam(value="area", defaultValue="90") int area
			,@RequestParam(value="price", defaultValue="130000") int price) {
		return realEstateBO.getAreaPrice(area, price);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
}
