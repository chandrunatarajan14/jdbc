package com.jdbc.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

class jdbcconnection {
	
	 static Connection connection=null;
	 static Statement statement=null;
	 static ResultSet rs=null;
	 
	 static {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
		 }
		 catch(ClassNotFoundException Ex) {
			 System.out.println(Ex.getMessage());
		 }
	 }
	 
	public static void main(String[] args)throws Exception {
		String query=null;
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","");
			statement=connection.createStatement();
		    query = "select*from items" ;
			statement.executeUpdate(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(1)+","+rs.getString(2)+","+rs.getInt(4));
			}
			
		}catch(Exception Ex) {
			Ex.printStackTrace();
			
		}finally {
			rs.close();
			statement.close();
			connection.close();
		}
		
		System.out.println("Done the connection");

	}

}
