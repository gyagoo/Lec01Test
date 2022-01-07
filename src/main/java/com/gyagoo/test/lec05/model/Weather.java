package com.gyagoo.test.lec05.model;

import java.util.Date;

public class Weather {
	private int id;
	private Date date;	
	private String weather;
	private double temperatures;
	private double pricipitation;
	private String microDust;
	private double windSpeed;
	private Date currentedAt;
	private Date updatedAt;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(double temperatures) {
		this.temperatures = temperatures;
	}
	public double getPricipitation() {
		return pricipitation;
	}
	public void setPricipitation(double pricipitation) {
		this.pricipitation = pricipitation;
	}
	public String getMicroDust() {
		return microDust;
	}
	public void setMicroDust(String microDust) {
		this.microDust = microDust;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Date getCurrentedAt() {
		return currentedAt;
	}
	public void setCurrentedAt(Date currentedAt) {
		this.currentedAt = currentedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
