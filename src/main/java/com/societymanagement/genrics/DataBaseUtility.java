package com.societymanagement.genrics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {
	Connection con=null;
public void connectToDB(String databaseNAme) throws SQLException {
	
	int rs=0;
	//Step 1: Register the database
	
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Step 2: get connection for the database
		con = DriverManager.getConnection(IPathConstant.RMGDBURL+databaseNAme,IPathConstant.RMGUSERNAME,IPathConstant.RMGPASSWORD);
	
}
 public String executeQueryAndgetData(String query,int columnIndex,String expData) throws SQLException {
		//Step 3: Issue create statment
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+"Record is martched");
			return expData;
		}
		else {
			System.out.println("Record is not matched");
			return "";
		}		
 }
 public void tearDownDB() throws SQLException {
	 con.close();
 }
}
