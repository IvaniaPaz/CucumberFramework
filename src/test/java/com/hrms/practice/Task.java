package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

public class Task {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	// jdbc:type driver:host:port/name of database
	String dbURL="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	@Test
	public void TaskSQLDB() throws SQLException {
		Connection conn=DriverManager.getConnection(dbURL,dbUsername,dbPassword);
		Statement stat= conn.createStatement();
		ResultSet rset=stat.executeQuery("select * from ohrm_job_title");
		
		ArrayList<String> arrData=new ArrayList<>();
		while(rset.next()) {
			arrData.add(rset.getString("job_title"));
		}
		for(String data:arrData) {
			System.out.println(data);
		}
		
	conn.close();
	stat.close();
	rset.close();
	}
}
