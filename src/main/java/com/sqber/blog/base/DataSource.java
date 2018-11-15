package com.sqber.blog.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sqber.blog.config.MySQLDataSourceConfig;
//import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class DataSource {
	private DataSource() {}
	
	public static HikariDataSource getInstance(){
		if(instance==null)
			instance = getDataSource();
        return instance;
    }
	
	
    private static HikariDataSource instance;
	
	@Autowired
	private MySQLDataSourceConfig mconfig;
	private static MySQLDataSourceConfig mmconfig;
	
	@PostConstruct
	public void init() {
		mmconfig = mconfig;
	}

    
    private static HikariDataSource getDataSource() {

//		HikariConfig config = new HikariConfig();
//
//		config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/javablog?useUnicode=true&characterEncoding=utf8&useSSL=false");
//		config.setUsername("root");
//		config.setPassword("123456");
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//		System.out.println("mmconfig" + mmconfig);
		
		return new HikariDataSource(mmconfig);
	}   
}


