package com.gyagoo.test.lec06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.test.lec06.bo.UrlBO;
import com.gyagoo.test.lec06.model.Url;

@Controller
public class UrlController {
	
	@Autowired
	private UrlBO urlBO;
	
	@GetMapping("/lec06/add_url_view")
	public String test01() {
		return "lec06/addUrl";
	}
	
	@ResponseBody
	@PostMapping("lec06/add_url")
	public String test02(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		int count = urlBO.addURL(name, url);
		
		// 삽입 성공하면 success 전달
		if(count == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	public String test03(Model model) {
		
		List<Url> url_list = urlBO.getUrl();
		model.addAttribute("url_list", url_list);
		
		return "lec06/url_list";
	}
	
}
