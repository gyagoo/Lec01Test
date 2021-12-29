package com.gyagoo.test.lec02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.test.lec02.bo.RealEstateBO;
import com.gyagoo.test.lec02.model.RealEstate;

@RestController
@RequestMapping("/lec03")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/test01")
	public RealEstate test01(@RequestParam(value="id", defaultValue="5") int id) {
		return realEstateBO.getRealEstate(id);
	}
	// 디폴트 값은 22였으나 테이블에 값이 존재하지 않아 5로 지정
	
	@RequestMapping("/test02")
	public List<RealEstate> test02(@RequestParam(value="rentPrice", defaultValue="90") int rentPrice) {
		return realEstateBO.getRentPrice(rentPrice);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
	@RequestMapping("/test03")
	public List<RealEstate> test03(@RequestParam(value="area", defaultValue="90") int area
							,@RequestParam(value="price", defaultValue="130000") int price) {
		return realEstateBO.getAreaPrice(area, price);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
}
