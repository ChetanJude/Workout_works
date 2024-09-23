package com.workoutworks.gms.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	public void getConnection() throws SQLException {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection("");
	Statement stmt = con.createStatement();
	ResultSet result = stmt.executeQuery(null);
	int in = stmt.executeUpdate(null);
	con.close();
	}

}
