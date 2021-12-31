package com.gyagoo.test.lec04.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec04.model.Seller;

@Repository
public interface SellerDAO {
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("profileImageUrl") String profileImageUrl
			, @Param("temperature") double temperature);
	
	public Seller selectSeller();
	
	public Seller findSeller(@Param("id") int id);
}
