package com.studentmanagement.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.studentmanagement.constants.Constants;

public class DBconnection {

	//creating method for driver loading
	public void loadDriver() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
    //creating method for getting connection
	public static Connection getConnection() {
		
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USR_NAME, Constants.DB_PWD);

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return connection;
	}

}
