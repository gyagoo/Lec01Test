package com.gyagoo.test.lec05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gyagoo.test.lec05.bo.WeatherBO;
import com.gyagoo.test.lec05.model.Weather;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("lec05/weather") // 날씨 정보를 보여주는 페이지
	public String getWeather(@ModelAttribute Weather weather, Model model) {
		
		model.addAttribute("weather", weather);	// model weather을 model에 객체 형태로 저장
		
		return "lec05/weather_main";
	}
	
	
	@GetMapping("/lec05/view")
	public String addWeatherView() {
		return "lec05/addWeather";
	}
	@PostMapping("lec05/add_weather")
	public String addWeather(@ModelAttribute Weather weather, Model model) {
		
		model.addAttribute("weather", weather);

		return "redirect:lec05/weather";
	}
	
	
}
