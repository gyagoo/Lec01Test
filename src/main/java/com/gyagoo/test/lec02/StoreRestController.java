package com.gyagoo.test.lec02;

import java.util.List;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.test.lec02.bo.StoreBO;

@RestController
public class StoreRestController {
	
	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lec02/test01")
	public List<Store> test01() {
		return storeBO.getStoreList();
	}
}
