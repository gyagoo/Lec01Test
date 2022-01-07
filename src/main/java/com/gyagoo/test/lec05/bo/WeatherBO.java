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
	
	public List<Weather> getWeather(Date date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		return weatherDAO.selectWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
	public int addWeather(Date date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		return weatherDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
