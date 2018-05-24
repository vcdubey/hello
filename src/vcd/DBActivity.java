package vcd;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DBActivity {
	private static Connection con = null; 
	
	public static Connection makeConnection() throws IOException {
		if(con != null) {
			return con;
		}
		Properties prop = new Properties();
		InputStream inputStream = First.class.getClassLoader().getResourceAsStream("/db.properties");
		prop.load(inputStream);
		String driver = prop.getProperty("driverClass");
		String url = prop.getProperty("connectionURL");
		String user = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		try {
			Class.forName(driver); 
			con=DriverManager.getConnection(url,user,password);
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static JSONArray fetchAllRecord() throws IOException {
		Connection con = makeConnection();
		JSONArray jarr = new JSONArray();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from country");
			while(rs.next()) {
				JSONObject ob = new JSONObject();
				System.out.println(rs.getString("code"));
				ob.put("code", rs.getString("code"));
				ob.put("name", rs.getString("name"));
				jarr.add(ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jarr;
	}
	
	public static boolean deleteRecord(String sql) throws IOException {
		Connection con = makeConnection();
		int count = 0;
		try {
			Statement st = con.createStatement();
			count = st.executeUpdate("delete from country where code = "+sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count == 0 ? false: true;
	}
	
	public static int updateRecord(String sql) throws IOException {
		Connection con = makeConnection();
		int count = 0;
		try {
			Statement st = con.createStatement();
			count = st.executeUpdate("update country set name ='India1' where code = "+sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
