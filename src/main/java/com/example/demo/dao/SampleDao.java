package com.example.demo.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class SampleDao extends DaoBase{
	private DummyConnection conn;

	public SampleDao() {
		this.conn = new DummyConnection();
	}
	public SampleDao(DummyConnection conn) {
		this.conn = conn;
	}

	@Transactional
	public String getData() {
		return "test_data"+conn.no;
	}
}