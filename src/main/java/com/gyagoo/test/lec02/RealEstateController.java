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
	
	@RequestMapping("/test01/1")
	public RealEstate test01_1(@RequestParam(value="id", defaultValue="5") int id) {
		return realEstateBO.getRealEstate(id);
	}
	// 디폴트 값은 22였으나 테이블에 값이 존재하지 않아 5로 지정
	
	@RequestMapping("/test01/2")
	public List<RealEstate> test01_2(@RequestParam(value="rentPrice", defaultValue="90") int rentPrice) {
		return realEstateBO.getRentPrice(rentPrice);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
	@RequestMapping("/test01/3")
	public List<RealEstate> test01_3(
			@RequestParam(value="area", defaultValue="90") int area
			,@RequestParam(value="price", defaultValue="130000") int price) {
		return realEstateBO.getAreaPrice(area, price);
	}
	// 디폴트 값은 예시에 나와있는 값으로 함
	
	// INSERT
	@RequestMapping("/test02/1")
	public String test02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateAsObject(realEstate);
		return "<h1>객체로 INSERT 하기</h1>입력 성공 : " + count;
	}
	@RequestMapping("/test02/2")
	public String test02_2(@RequestParam("realtorId") int realtorId) {
		int count = realEstateBO.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "<h1>필드로 INSERT 하기</h1>입력 성공 : " + count;
	}
	
	@RequestMapping("/test03")
	public String test03() {
		int count = realEstateBO.updateRealEstate(5, "전세", 70000);	
		// 예제에서는 id=24 였으나 row가 존재하지 않아 5로 입력
		return "<h1>필드로 UPDATE 하기</h1>수정 성공 : " + count;
	}
	
	@RequestMapping("/test04")
	public String test04(@RequestParam("id") int id) {
		int count = realEstateBO.delRealEstate(id);
		return "<h1>DELETE</h1>삭제 성공 : " + count;
	}
}
