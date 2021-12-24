package com.gyagoo.test.lec01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lec01/test01")
public class Test01Controller {
	
    @RequestMapping("/00")
    public String helloWorld() {
        return "Hello World!!";
    }
	
	@RequestMapping("/01")
	public String pringString() {
		String str = "<h1>테스트 프로젝트 완성</h1> 해당 프로젝트를 통해서 문제 풀이를 진행합니다.";
		return str;		
	}
	
	@RequestMapping("/02")
	public Map<String, Integer> printMap() {
		Map<String, Integer> score = new HashMap<>();
		score.put("국어", 80);
		score.put("수학", 90);
		score.put("영어", 85);
		
		return score;
	}
}
