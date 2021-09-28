package com.amdocs.project.db;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
public class DataSourceUtil {

    
	public static DataSource dataSource() {
		try {
			BasicDataSource bds = new BasicDataSource();
			bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			bds.setUrl("jdbc:mysql://localhost:3306/amdocs_project");
			bds.setUsername("root");
			bds.setPassword("devanshu452");
			return bds;
		} catch (Exception ex) {
			return null;
		}
	}
}