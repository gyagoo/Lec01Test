package com.gyagoo.test.lec04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec04.dao.RealtorDAO;
import com.gyagoo.test.lec04.model.Realtor;

@Service
public class RealtorBO {

	@Autowired
	private RealtorDAO realtorDAO;
	
	public int addRelator(Realtor realtor) {
		return realtorDAO.insertRealtor(realtor);
		
	}
}
