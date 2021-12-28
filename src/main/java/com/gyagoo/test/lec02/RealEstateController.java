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
	
	@RequestMapping("/test02")
	public List<RealEstate> test02(@RequestParam("rentPrice") int rentPrice) {
		return realEstateBO.getRentPrice(rentPrice);
	}
	
//	@RequestMapping("/test03")
//	public RealEstate test03(@RequestParam("area") int area
//							,@RequestParam("price") int price) {
//		return realEstateBO
//	}
}
