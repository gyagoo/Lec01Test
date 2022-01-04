package com.gyagoo.test.lec05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController01 {

	@GetMapping("/lec05/test01")
	public String test01() {
		return "lec05/test01";
	}
}
