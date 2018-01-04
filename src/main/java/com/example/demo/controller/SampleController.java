package com.example.demo.controller;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LogDao;
import com.example.demo.dao.Sample2Dao;
import com.example.demo.dao.SampleDao;
import com.example.demo.service.SampleService;
import com.google.gson.GsonBuilder;


@RestController
@RequestMapping(value = "/rest")
public class SampleController extends BaseController{

    @Autowired
    private SampleDao sampleDao;

    @Autowired
    private Sample2Dao sample2Dao;

    @Autowired
    private LogDao logDao;

    @Autowired
    private SampleService sampleService;

    @RequestMapping("/")
    public String index() {
		return sampleDao.getData();
    }

    @RequestMapping("hello")
    public String hello() {
    	sample2Dao.inc();
		return sample2Dao.getData();
    }

    @RequestMapping("getLogs")
    public String getLogs() throws SQLException {
		//return gson.toJson(logDao.selectList());
    	return new GsonBuilder().setPrettyPrinting().create().toJson(logDao.selectList());
    }

    //http://www.shookuro.com/entry/2016/08/21/134349
    @RequestMapping("putLogs")
    public String putLogs() {
    	sampleService.rollbackLogs();
		return "1";
    }

    //http://www.shookuro.com/entry/2016/08/21/134349
    @RequestMapping("putLogs2")
    public String putLogs2() {
    	sampleService.commitLogs();
		return "1";
    }


}