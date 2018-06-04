package com.automation.utility;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQuery {
	
	public static void establishDbConnection() throws IOException{
		DataBaseOracle.establishConnection();
	}
	
	public static void closeDbConnection() throws SQLException {
		DataBaseOracle.closeDbConnection();
	}
	
	public static String getXMLData(String order_Id) throws SQLException{
		String query = "select * from tribute.TRIBUTE_SERVICES_ORDERS where source_order_id = '" + order_Id +"'";
		ResultSet rs = DataBaseOracle.executeQuery(query);
		while(rs.next()){
			rs.getString(3);
		}
		return null;		
	}
	
	
	public static String getValue1(String order_Id) throws SQLException{
		String query = "select e.* from tribute.donor d " 
						+ "inner join tribute.address a on a.address_id = d.address_id " 
						+ "inner join tribute.email e on e.email_join_id = d.email_join_id "
						+ "where  d.source_order_id = '" + order_Id +"'";
	
		ResultSet rs = DataBaseOracle.executeQuery(query);
		while(rs.next()){
			rs.getString(3);
		}
		return null;
	}
//--inner join tribute.telephone t on t.telephone_join_id = d.telephone_join_id
	
	public static String getValue2(String order_Id) throws SQLException{
		String query = "select f.* from tribute.donor d " + " "
						+ "inner join tribute.donation do on do.donor_id = d.donor_id " 
						+ "inner join tribute.FULFILLMENT_DETAIL f on do.fulfillment_id = f.fulfillment_id "
						+ "inner join tribute.FULFILLMENT_order fo on fo.fulfillment_id = f.fulfillment_id "
						+ "where d.source_order_id = '" + order_Id +"'";
	
		ResultSet rs = DataBaseOracle.executeQuery(query);
		while(rs.next()){
			rs.getString(3);
		}
		return null;
	}
	
	public static String getValue3(String order_Id) throws SQLException{
		String query =  "select t.* from tribute.donor d "
						+ "inner join tribute.donation do on do.donor_id = d.donor_id "
						+ "inner join tribute.tributee t on do.DONATION_ID = t.donation_id "
						+ "inner join tribute.RECIPIENT r on do.DONATION_ID = r.donation_id "
						+ "inner join tribute.MEMORIAL m on t.memorial_id = m.memorial_id "
						+ "where  d.source_order_id = '" + order_Id +"'";
		ResultSet rs = DataBaseOracle.executeQuery(query);
		while(rs.next()){
			rs.getString(3);
		}
		return null;
	}
	
}
