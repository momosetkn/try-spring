package com.example.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DS {

    private static HikariDataSource ds;

    public void init() {
    	getDataSource();
    }

    private DS() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static HikariDataSource getDataSource() {
    	if( ds == null ) {
    		HikariConfig config = new HikariConfig();
    		config.setDriverClassName("org.h2.Driver");
	        config.setJdbcUrl( "jdbc:h2:./db/test;" );
	        config.setUsername( "user" );
	        config.setPassword( "" );

	        config.setMaximumPoolSize(5);//とりあえずテスト的にプールサイズ５にしとくか
	        config.setAutoCommit(false);

	        config.addDataSourceProperty( "cachePrepStmts" , "true" );
	        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
	        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
	        ds = new HikariDataSource( config );
    	}
    	System.out.println("getDataSource() {");
    	return ds;
    }

    public static void close() {
    	if( ds != null ) {
    		ds.close();
    	}
    }
}