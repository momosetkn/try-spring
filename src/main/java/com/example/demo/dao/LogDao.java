package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class LogDao {

	/** ここ実行するとテーブル作られるよ */
	public static void main(String... args) throws Exception {
		LogDao logDao = new LogDao();
		logDao.jdbcTemplate = new JdbcTemplate(DS.getDataSource());
		//PlatformTransactionManager tsMgr = new DataSourceTransactionManager(logDao.jdbcTemplate.getDataSource());
		//logDao.runner = new QueryRunner();

		logDao.createTable();
		logDao.insert("taro", "hello",  new Timestamp(System.currentTimeMillis()) );
		logDao.insert("taro", "hello!",  new Timestamp(System.currentTimeMillis()) );

		List<Log> logList = logDao.selectList();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println( gson.toJson(logList) );
		//org.h2.tools.Server.main(null);
		DS.getDataSource().close();
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createTable() {
		jdbcTemplate.execute("drop table if exists log");
		jdbcTemplate.execute("create table log("
				+ "disp_no bigint auto_increment, "
					+ "sender varchar, "
				+ "msg varchar, "
				+ "saydate timestamp )");
	}

	public int insert(String sender, String msg, Timestamp saydate){
		System.out.println("insertData="+sender+":"+msg+":"+saydate);
		Integer res = jdbcTemplate.update( "insert into log (sender, msg, saydate) values ( ?, ?, ?)", sender, msg, saydate);
		System.out.println("insert result="+res);
		return res;
	}

	public List<Log> selectList() {

		List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from log ");
		List<Log> logList = new ArrayList<>();
		for(Map<String, Object> map: mapList) {
			Log log = new Log();
			log.setDispNo((Long)map.get("disp_no"));
			log.setMsg((String)map.get("msg"));
			log.setSayDate((Timestamp)map.get("saydate"));
			log.setSender((String)map.get("sender"));
			logList.add(log);
		}
		return logList;
	}


}
