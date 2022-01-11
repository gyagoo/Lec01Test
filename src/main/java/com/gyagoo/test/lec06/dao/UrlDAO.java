package com.gyagoo.test.lec06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gyagoo.test.lec06.model.Url;

public interface UrlDAO {

	public int insertDAO(
			@Param("name") String name,
			@Param("url") String url);
	
	public List<Url> selectUrl();
}
