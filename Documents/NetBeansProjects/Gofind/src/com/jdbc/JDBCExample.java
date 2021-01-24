/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdbc;

import java.sql.*;


public class JDBCExample {

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        
	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		throw new ClassNotFoundException(e.getMessage());
	}

	System.out.println("MySQL JDBC Driver Registered!");
	

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/gofind","root", "");

                return connection;
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		throw new SQLException(e.getMessage());
	}
  }
}
