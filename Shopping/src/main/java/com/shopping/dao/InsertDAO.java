package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import com.shopping.database.MysqlConnection;

public class InsertDAO {
	
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	MysqlConnection conn = new MysqlConnection();
	String query = null;
	ArrayList<HashMap<Object,Object>> returnArray = new ArrayList<HashMap<Object,Object>>();
	HashMap<Object,Object> mapList = new HashMap<Object,Object>();
	
    public ArrayList<HashMap<Object,Object>>  insertTopMenu(String title,String menulevel,String menuid) throws Exception {
    	//상단 메뉴 데이터 ROW INSERT
    	try {
    		query = "INSERT INTO topmenu(title,menulevel,menuid,reg_dt,upd_dt)"
    			  + "Values (?,?,?,now(),now())";
			con = conn.connection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, menulevel);
			pstmt.setString(3, menuid);
			pstmt.executeUpdate();
			mapList.put("result", "201");
			returnArray.add(mapList);
		} catch (Exception e) {
			e.printStackTrace();
			mapList.put("result", "401");
			returnArray.add(mapList);
		} finally {
			conn.close(con,pstmt);
		}
    	return returnArray;
    }
}
