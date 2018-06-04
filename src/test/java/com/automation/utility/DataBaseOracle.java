package com.automation.utility;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseOracle {
	
	static Connection dbConnection = null;
	public static String db_url = "";
	public static String username = "";
	public static String password = "";
	public static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

	
	public static void establishConnection() throws IOException {
		makeConnection(jdbcDriver, db_url, username, password);
	}
	
	public static void makeConnection(String jdbcDriver, String db_url, String username, String password) {
		 
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {

			dbConnection = DriverManager.getConnection(db_url, username, password);
			System.out.println("connection established");
		} catch (SQLException e) {
			System.out.println("in catch ?");
			System.out.println(e.getMessage());
		}

	}

	public void executeUpdateQuery(String query) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		stmt.executeUpdate(query);
	}

	public static ResultSet executeQuery(String query) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		return rs;
	}

	public static void closeDbConnection() throws SQLException {
		dbConnection.close();
	}

	/*public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin.....", "", "");
		
		Statement st = con.createStatement();
		
		//st.executeUpdate("UPD where user_id= 114");
		
		ResultSet rs = st.executeQuery("");
		
		while(rs.next()){
			System.out.println(rs.getInt(1) + "  " + rs.getString(5) + " " + rs.getSQLXML(4));
		}
		
		
	}*/
}
