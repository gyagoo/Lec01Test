package com.gyagoo.test.lec06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@PostMapping("/lec06/add_url")
	public String test02(			// insert
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
	@GetMapping("/lec06/url_list")
	public String test03(Model model) {
		
		List<Url> url_list = urlBO.getUrl();
		model.addAttribute("url_list", url_list);
		
		return "lec06/url_list";		// 무엇을 return 할 것인가? jsp 경로 !
	}
//	test02
	@ResponseBody
	@PostMapping("/lec06/duplicate_url") // Get -> Post
	public Map<String, String> duplicateUrl(@RequestParam("url") String url) {
		Map<String, String> result = new HashMap<>();
		
		if (urlBO.isDuplicateUrl(url) == true) {
			result.put("isDuplicate", "true");
		} else {
			result.put("isDuplicate", "false");
		}
		
		return result;
	}
//	delete
	@ResponseBody
	@GetMapping("/lec06/delete_url")	// id만 받으면 되기 때문에 Get
	public String deleteUrl(@RequestParam("id") int id) {
		int count = urlBO.deleteUrl(id);
		
		if (count == 0) {
			return "fail";
		} else {
			return "success";	// id는 유일하기 때문에 0이 아닌 경우는 모두 삭제가 성공됨을 의미
		}
		// id를 어떻게 전달할 것인가?
	}

	
}
