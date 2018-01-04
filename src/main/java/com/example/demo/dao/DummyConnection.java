package com.example.demo.dao;

public class DummyConnection {
	private static int counter = 0;
	public int no = 0;

	public DummyConnection() {
		no = counter;
		counter++;
		System.out.println("DummyConnectionつくったよ"+no);
	}

	public String toString(){
		return "コネクションID="+no;
	}
}
