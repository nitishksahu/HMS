package com.hms.model;


	import java.sql.Connection;
	import java.sql.DriverManager;

//DOES THE CONNECTION OF JAVA BEAN TO THE DATABSE
	public class DBConnection {
		public Connection getConnection()
		{
			Connection con=null;
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(Exception e)
			{
				System.out.println("Class Path Not Defined");
			}
			String url="jdbc:oracle:thin:@192.168.129.12:1521:orcl";
			String username="a07c";
			String password="a07c";
			
			try{
			con=DriverManager.getConnection(url,username,password);
			}
			catch(Exception e)
			{
				System.out.println("Connection not Established");
			}
			return con;
		}
		
		
	}

