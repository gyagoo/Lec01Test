package com.gyagoo.test.lec04.bo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec04.dao.SellerDAO;
import com.gyagoo.test.lec04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, String profileImageUrl, double temperature ) {
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getSeller() {
		return sellerDAO.selectSeller();
	}
	
	public Seller findSeller(int id) {
		return sellerDAO.findSeller(id);
	}
}
