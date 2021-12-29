package com.gyagoo.test.lec02.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec02.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	public List<RealEstate> selectRentPrice(@Param("rentPrice") int rentPrice);	
	public List<RealEstate> selectAreaPrice(@Param("area") int area, @Param("price") int price);
	
	
	
	
	
}
