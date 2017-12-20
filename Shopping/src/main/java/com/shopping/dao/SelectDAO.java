package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

import com.shopping.database.MysqlConnection;

public class SelectDAO {
	private static ResultSet rs = null;
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	MysqlConnection conn = new MysqlConnection();
	String query = null;
	ArrayList<HashMap<Object,Object>> returnArray = new ArrayList<HashMap<Object,Object>>();
	
	public ArrayList<HashMap<Object,Object>> queryMap(String query) throws Exception{
		HashMap<Object,Object> mapList = new HashMap<Object,Object>();
		try{
			con = conn.connection();
			mapList.put("result"  , "200");
			returnArray.add(mapList);

			ResultSetMetaData rsmd = null;
			pstmt = con.prepareStatement(query.toString(), rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		    rs = pstmt.executeQuery();
		    rsmd = rs.getMetaData();
			while (rs.next()){
				mapList = new HashMap<Object, Object>();
				for(int i=1;i<=rsmd.getColumnCount(); i++){
					 if (rs.getString(rsmd.getColumnName(i)) != null && !rs.wasNull()) {
						 mapList.put(rsmd.getColumnName(i)  , rs.getString(rsmd.getColumnName(i)));
					 }else{
						 mapList.put(rsmd.getColumnName(i)  , "");
					 }
				}
				returnArray.add(mapList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mapList.put("result"  , "400");
			returnArray.add(mapList);
		} finally {
			conn.close(con, rs, pstmt);
		}
		return returnArray;
	}
	
    public ArrayList<HashMap<Object,Object>> selectTopMenu() throws Exception {
    	//상단 메뉴 데이터 TITLE 조회
    		query = "select * from topmenu ORDER BY reg_dt asc , menuid asc";
    		returnArray = queryMap(query);
    	return returnArray;
    }
	
}

    