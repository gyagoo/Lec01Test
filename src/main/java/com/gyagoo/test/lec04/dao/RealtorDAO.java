package com.gyagoo.test.lec04.dao;

import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec04.model.Realtor;

@Repository
public interface RealtorDAO {

	public int insertRealtor(Realtor realtor);

	
}
