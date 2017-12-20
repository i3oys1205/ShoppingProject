package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class MysqlConnection {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL    = "jdbc:mysql://localhost:3306/shopping?useSSL=false&serverTimezone=UTC";
	private static final String USER   = "shopping";
	private static final String PW     = "1234";
	public  Connection conn = null;
	
	@Test
	public Connection connection() throws Exception {
		Class.forName(DRIVER);
		try {
			conn = DriverManager.getConnection(URL, USER, PW); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn , PreparedStatement pstmt) throws Exception {
		try {
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
		}
	}
	public void close(Connection conn , ResultSet rs , PreparedStatement pstmt ) throws Exception {
		try {
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
		}
	}
}
