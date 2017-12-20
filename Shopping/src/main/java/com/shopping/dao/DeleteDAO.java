package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import com.shopping.database.MysqlConnection;

public class DeleteDAO {
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	MysqlConnection conn = new MysqlConnection();
	String query = null;
	ArrayList<HashMap<Object,Object>> returnArray = new ArrayList<HashMap<Object,Object>>();
	HashMap<Object,Object> mapList = new HashMap<Object,Object>();
	
    public ArrayList<HashMap<Object,Object>>  deleteTopMenu(String title) throws Exception {
    	//상단 메뉴 데이터 ROW INSERT
    	try {
    		query = "delete from topmenu where title = ?";
			con = conn.connection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			mapList.put("result", "202");
			returnArray.add(mapList);
		} catch (Exception e) {
			e.printStackTrace();
			mapList.put("result", "402");
			returnArray.add(mapList);
		} finally {
			conn.close(con,pstmt);
		}
    	return returnArray;
    }
}
