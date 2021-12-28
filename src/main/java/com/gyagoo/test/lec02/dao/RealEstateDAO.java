package com.gyagoo.test.lec02.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec02.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	public List<RealEstate> selectRentPrice(@Param("rentPrice") int rentPrice);
	public interface realEstateMapper {
		public RealEstate getAreaPrice(HashMap<String, Object> map);	// String, Object
	}
	
}
