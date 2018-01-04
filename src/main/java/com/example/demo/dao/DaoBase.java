package com.example.demo.dao;

public class DaoBase{
	private DummyConnection conn;

	public void open() {
		this.conn = new DummyConnection();
		System.out.println("DaoBase#open()");
	}

	public void close() {
		this.conn = null;
		System.out.println("DaoBase#close()");
	}
}