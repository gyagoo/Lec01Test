package com.gyagoo.test.lec04;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.test.lec04.bo.SellerBO;
import com.gyagoo.test.lec04.model.Seller;

@Controller
@RequestMapping("/lec04")
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	@RequestMapping("/test01/1")
	public String addSellerView() {
		return "lec04/addSeller";
	}
	@ResponseBody
	@RequestMapping("test01/add_seller")
	public String addSeller(
			@Param("nickname") String nickname
			, @Param("profileImageUrl") String profileImageUrl
			, @Param("temperature") double temperature) {
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "입력 성공 : " + count;
	}

	
	@RequestMapping("/test01/2")
	public String getSeller(Model model) {
		
		Seller seller = sellerBO.getSeller();
		model.addAttribute("result", seller);
		
		return "lec04/sellerInfo";
	}
	
	
	@RequestMapping("/test01/3")
	public String findSeller(@RequestParam(value="id", defaultValue="1") int id, Model model) {
		
		Seller seller = sellerBO.findSeller(id);
		model.addAttribute("result", seller);
		
		return "lec04/sellerInfo";
	}
}
