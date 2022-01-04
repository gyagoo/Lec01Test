package com.gyagoo.test.lec04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyagoo.test.lec04.bo.RealtorBO;
import com.gyagoo.test.lec04.model.Realtor;

@Controller
@RequestMapping("/lec04/test02")
public class RealtorController {
	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/1")
	public String addRealtorView() {
		return "lec04/addRealtor";
	}
	
	@PostMapping("/addRealtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, Model model) {
		
		int count = realtorBO.addRelator(realtor);
		
		model.addAttribute("result", realtor);
		
		return "lec04/realtorInfo";
	}
}
