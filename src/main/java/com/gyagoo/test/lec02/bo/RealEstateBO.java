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
	// test01_1
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	// test01_2
	public List<RealEstate> getRentPrice(int rentPrice) {
		return realEstateDAO.selectRentPrice(rentPrice);
	}
	// test01_3
	public List<RealEstate> getAreaPrice(int area, int price) {
		return realEstateDAO.selectAreaPrice(area, price);
	}
	// test02_1
	public int addRealEstateAsObject(RealEstate realEstate) {
		return realEstateDAO.insertRealEstateAsObject(realEstate);
	}
	
	// test02_2
	public int addRealEstate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
	}
	
	// test03
	public int updateRealEstate(int id, String type, int price) {
		return realEstateDAO.updateRealEstateAsObject(id, type, price);
	}
	
	// test04
	public int delRealEstate(int id) {
		return realEstateDAO.delRealEstate(id);
	}
}


