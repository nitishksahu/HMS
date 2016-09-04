package com.hms.model;
import java.sql.*;
import java.util.ArrayList;
public class ValidateOpd {
	
	
public static ArrayList<Integer> Validate(int opdno)
{
	ArrayList<Integer> arr=new ArrayList<Integer>();
	DBConnection database=new DBConnection();
	Connection con=database.getConnection();
	if(con!=null)
		System.out.println("Connection done");
	else
		System.out.println("Connection not done");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="SELECT *FROM OUTPATIENT WHERE OPDNO=?";
	try {
		pstmt=con.prepareStatement(sql);
	} catch (SQLException e) {
	    System.out.println("Statement creation failed");
		e.printStackTrace();
	}
	try {
		pstmt.setInt(1,opdno);
	} catch (SQLException e) {
	System.out.println("Insertion failed");
		e.printStackTrace();
	}
	try {
		rs=pstmt.executeQuery();
	} catch (SQLException e) {
		System.out.println("Query not executed");
		e.printStackTrace();
	}
	
   try {
	while(rs.next())
	   {
		  arr.add(rs.getInt(1)); 
	   }
} catch (SQLException e) {
	   e.printStackTrace();
}
		return arr;
		}
	}
	
	
	
	



