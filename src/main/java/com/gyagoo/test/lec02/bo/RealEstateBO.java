package com.gyagoo.test.lec02.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec02.dao.RealEstateDAO;
import com.gyagoo.test.lec02.model.RealEstate;

@Service
public class RealEstateBO{
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	// test01
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	// test02
	public List<RealEstate> getRentPrice(int rentPrice) {
		return realEstateDAO.selectRentPrice(rentPrice);
	}
	// test03
	public List<RealEstate> getAreaPrice(int area, int price) {
		return realEstateDAO.selectAreaPrice(area, price);
	}
}
