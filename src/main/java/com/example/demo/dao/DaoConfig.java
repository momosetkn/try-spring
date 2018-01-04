package com.example.demo.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
@ComponentScan("com.example.demo")
@EnableAspectJAutoProxy
public class DaoConfig {

//	@Bean
//	DummyConnection getConnection() {
//		return new DummyConnection();
//	}
//	@Bean
//	public SampleDao getSampleDao(DummyConnection conn) {
//		return new SampleDao(conn);
//	}
//
//	@Bean
//	public Sample2Dao getSample2Dao(DummyConnection conn) {
//		return new Sample2Dao(conn);
//	}
	@Bean
	@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )
	public DummyConnection connection() {
		return new DummyConnection();
	}
//Springでトランザクション管理 - Qiita https://qiita.com/NagaokaKenichi/items/a279857cc2d22a35d0dd
	@Bean(initMethod="open", destroyMethod="close")
	@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )
	public SampleDao getSampleDao(DummyConnection conn) {
		System.out.println("getSampleDao() {");
		return new SampleDao(conn);
	}
	//@PreAuthoirze
	//@org.springframework.security.access.prepost.PreAuthorize
	@Async
	@Retryable
	@Bean(initMethod="open", destroyMethod="close")
	@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS )
	public Sample2Dao getSample2Dao(DummyConnection conn) {
		System.out.println("getSample2Dao() {");
		return new Sample2Dao(conn);
	}

//	@Bean(initMethod="init", destroyMethod="close")
//	DataSource getDataSource() {
//	    return DS.getDataSource();
//	}
//
//	DataSourceTransactionManager transactionManager() {
//	    return new DataSourceTransactionManager( DS.getDataSource());
//	}
//	@Bean
//	public QueryRunner getQueryRunner() {
//		return new QueryRunner();
//	}
	//[SpringでAOP \- Qiita](https://qiita.com/NagaokaKenichi/items/386af61b6866d60964e8)
	//[@Component、@Service、@Repository、@Controllerの違いについて \- Qiita](https://qiita.com/KevinFQ/items/abc7369cb07eb4b9ae29)

	//[Spring Boot \+ HikariCPでコネクションプールのMetricsを取得する \- @matsumana の技術メモ](https://matsumana.info/blog/2016/02/06/spring-boot-hikaricp-metrics/)
	@Bean(destroyMethod="close")
	public DataSource getDataSource() {
		return DS.getDataSource();
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	//NamedParametorJdbcTemplateもある。名前付き引数ってことかな。

	@Bean
	public Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}

//	//[Spring Boot \+ HikariCPでコネクションプールのMetricsを取得する \- @matsumana の技術メモ](https://matsumana.info/blog/2016/02/06/spring-boot-hikaricp-metrics/)
//	@Bean(destroyMethod="close")
//	public DataSource getDataSource() {
//		return DS.getDataSource();
//	}
}
