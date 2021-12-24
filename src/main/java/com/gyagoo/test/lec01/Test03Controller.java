package com.gyagoo.test.lec01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("/lec01/test03")
	public String view() {
		return "/lec01/test03";
	}
}
