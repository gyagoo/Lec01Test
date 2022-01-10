package com.gyagoo.test.lec05.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec05.model.Weather;

@Repository
public interface WeatherDAO {
	
	public List<Weather> selectWeather();
	
	public int insertWeather(Weather weather);
}
