package com.gyagoo.test.lec02.dao;

import java.util.List;

import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDAO {
	
	public List<Store> selectStoreList();
	
}
