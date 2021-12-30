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
	
	public int insertRealEstateAsObject(RealEstate realEstate);
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	public int updateRealEstateAsObject(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	// 업데이트를 할 때 확장성을 생각해서 객체로 전달하기로 함
//	-> 메모리 낭비, UDPATE는 파라미터로 전달하는게 바람직
	public int delRealEstate(@Param("id") int id);
	
}
