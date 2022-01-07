package com.gyagoo.test.lec05.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.test.lec05.model.Weather;

@Repository
public interface WeatherDAO {
	
	public List<Weather> selectWeather(
			 @Param("date") Date date
			 , @Param("weather") String weather
			 , @Param("temperatures") double temperatures
			 , @Param("precipitation") double precipitation
			 , @Param("microDust") String microDust
			 , @Param("windSpeed") double windSpeed);
	
	public int insertWeather(
			 @Param("date") Date date
			 , @Param("weather") String weather
			 , @Param("temperatures") double temperatures
			 , @Param("precipitation") double precipitation
			 , @Param("microDust") String microDust
			 , @Param("windSpeed") double windSpeed);
}
