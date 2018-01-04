package com.example.demo.service;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.LogDao;

@Component
public class SampleService{

    @Autowired
    private LogDao logDao;

	@Transactional
	public void rollbackLogs() {
		logDao.insert("taro", "hello", new Timestamp(System.currentTimeMillis()) );
		throw new RuntimeException();
	}

	@Transactional
	public void commitLogs() {
		logDao.insert("taro", "hello", new Timestamp(System.currentTimeMillis()) );
	}


}