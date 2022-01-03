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
//	test 1
	@ResponseBody
	@RequestMapping("test01/add_seller")
	public String addSeller(
			@Param("nickname") String nickname
			, @Param("profileImageUrl") String profileImageUrl
			, @Param("temperature") double temperature) {
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "입력 성공 : " + count;
	}

//	test 2 + 3
//	query가 달라지면 BO 와 DAO 는 따로 만들어야 함
	@RequestMapping("/test01/2")
	public String findSeller(@RequestParam(value="id", required=false) Integer id, Model model) {
		// "id" 형태로 받아온 값을 id 에 저장하게 됨
		// default : required=true 가 포함 -> required=false 로 바꿔 입력받은 id 가 없어도 처리되도록 변경
		// int 는 null 불가능 -> Integer 로 변경
		
		if (id == null) {
			Seller seller = sellerBO.getSeller();
			model.addAttribute("result", seller);			
		} else {
			Seller seller = sellerBO.findSeller(id);
			model.addAttribute("result", seller);
		}

		return "lec04/sellerInfo";
	}
}
