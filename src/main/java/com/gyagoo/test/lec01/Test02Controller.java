package com.gyagoo.test.lec01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lec01/test02")
public class Test02Controller {
	
	@RequestMapping("/01")
	public List<Map<String, Object>> MovieList() {
		// List 선언
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		// Map 선언
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		movieList.add(map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("rate", 0);
		map2.put("director", "로베르트 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		movieList.add(map2);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		movieList.add(map3);
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("rate", 19);
		map4.put("director", "윤솔빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(map4);
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");
		movieList.add(map5);
		
		return movieList;
	}
	
	@RequestMapping("/02")
	public List<BoardContent> boardList() {
		List<BoardContent> boardList = new ArrayList<>();
		
		BoardContent content = new BoardContent();
		content.setTitle("안녕하세요 가입인사 드립니다.");
		content.setUser("hagulu");
		content.setContent("안녕하세요 가입했습니다 잘 부탁 드립니다~");
		boardList.add(content);
		
		content = new BoardContent();
		content.setTitle("헐 대박");
		content.setUser("hada");
		content.setContent("오늘 개춥네요");
		boardList.add(content);
		
		content = new BoardContent();
		content.setTitle("오늘 똥 밟았어요");
		content.setUser("dulumary");
		content.setContent("밟았네또옹");
		boardList.add(content);
		
		return boardList;
	}

	@RequestMapping("/03")
	public ResponseEntity<BoardContent> entity() {
		// 데이터가 여러개일 경우 <list>
		BoardContent content = new BoardContent();
		content.setTitle("안녕하세요 가입인사 드립니다.");
		content.setUser("hagulu");
		content.setContent("안녕하세요 가입했습니다 잘 부탁 드립니다~");
		
		ResponseEntity<BoardContent> entity = new ResponseEntity<>(content, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
}
