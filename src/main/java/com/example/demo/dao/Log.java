package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.Objects;

public class Log {
	private Long dispNo;
	private String sender;
	private String msg;
	private Timestamp sayDate;

	public Long getDispNo() {
		return dispNo;
	}

	public void setDispNo(Long disp_no) {
		this.dispNo = disp_no;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getSayDate() {
		return sayDate;
	}

	public void setSayDate(Timestamp saydate) {
		this.sayDate = saydate;
	}

	@Override
	public String toString() {
		return "Log [disp_no=" + dispNo + ", sender=" + sender + ", msg=" + msg + ", saydate=" + Objects.toString(sayDate) + "]";
	}


}
