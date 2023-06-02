package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	

	public static void main(String[] args) throws SQLException {
//1		// TODO Auto-generated method stub
		//When adding your mysql dependencies in the pom.xml file. Remember that if you are using 
		//a different DB then the DB's dependencies is to be added eg oracle require oracle dependencies
		//same as in it's connection mysql changes to whatever the database is
		//URL or localhost 139....96, userName produser, password qw...23! 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV",
				"produser", "qweQWe123!");
		Statement statement = connection.createStatement();
		
		 ResultSet result = statement.executeQuery("SELECT * from mst_oem mo  WHERE name = 'Apple' ");
		while (result.next()) {
			
			System.out.println(result.getInt("id"));
			System.out.println(result.getString("name"));
			System.out.println(result.getString("code"));
			System.out.println(result.getString(5));
			System.out.println(result.getString(6));
		}

	}

}
