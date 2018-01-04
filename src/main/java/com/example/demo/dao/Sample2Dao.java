package com.example.demo.dao;

//@Component
//@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )
//@Scope(value="request")

//@Component
//@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS )
//@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )//これないとシングルトンになる
//こっちで@ComponentとかかくとConfigration使われない
public class Sample2Dao extends DaoBase{
	private DummyConnection conn;
	private int i;
	public Sample2Dao() {
		System.out.println("Sample2Daoの引数梨コンストラクタ");
		this.conn = new DummyConnection();
	}
	public Sample2Dao(DummyConnection conn) {
		System.out.println("Sample2Daoの引数ありコンストラクタ");
		this.conn = conn;
	}

	public void inc() {
		i=i+1;
		System.out.println(i);
	}

	public String getData() {
		return "test_data"+conn.no+":"+i;
	}


}