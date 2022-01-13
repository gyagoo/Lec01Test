package com.gyagoo.test.lec06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.test.lec06.dao.UrlDAO;
import com.gyagoo.test.lec06.model.Url;

@Service
public class UrlBO {

	@Autowired
	private UrlDAO urlDAO;
	
	public int addURL(String name, String url) {
		return urlDAO.insertUrl(name, url);
	}
	public List<Url> getUrl() {
		return urlDAO.selectUrl();
	}
	
	// test02
	public Boolean isDuplicateUrl(String url) {
		int count = urlDAO.selectCountUrl(url);
		if (count == 0) {
			return false;	// count가 0이면 중복X
		} else {
			return true;
		}
	}
	
	public int deleteUrl(int id) {
		return urlDAO.deleteUrl(id);
	}
}
