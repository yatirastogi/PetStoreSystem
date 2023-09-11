package com.amdocs.DAO;

import java.sql.*;

//to establish connection to database 

class MakeConnection
{
	 public static Connection getConnection() //function returns a connection 
	 {
			Connection con=null;
			 try {
				 Class.forName("oracle.jdbc.driver.OracleDriver"); //registration
				 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger"); //connection
				 
			 }catch(Exception e) {
				 System.out.println("Error in connection");
			 }
			 return con;
		 }
		
}