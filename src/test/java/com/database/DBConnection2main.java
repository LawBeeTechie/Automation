package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection2main {
	

	public static void main(String[] args) throws SQLException {
	Connection connection = DBConnector.getConnection();
		
		Statement statement = connection.createStatement();
		
		 ResultSet result = statement.executeQuery("SELECT * from mst_oem mo  WHERE name = 'Apple' ");
		while (result.next()) {
			
			System.out.println(result.getInt("id"));
			System.out.println(result.getString("name"));
			System.out.println(result.getString("code"));
			System.out.println(result.getString(5));
			System.out.println(result.getString(6));
			
			Connection connection1 = DBConnector.getConnection();
			Connection connection2 = DBConnector.getConnection();
			System.out.println(connection1);
			System.out.println(connection2);
		}

	}

}
