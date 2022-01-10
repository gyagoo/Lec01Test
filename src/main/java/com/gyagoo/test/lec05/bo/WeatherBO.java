package com.gyagoo.test.lec05.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec05.dao.WeatherDAO;
import com.gyagoo.test.lec05.model.Weather;

@Service
public class WeatherBO {
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weather> getWeather() {
		return weatherDAO.selectWeather();
	}
	
	public int addWeather(Weather weather) {
		return weatherDAO.insertWeather(weather);
	}
}
