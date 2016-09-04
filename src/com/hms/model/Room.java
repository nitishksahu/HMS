package com.hms.model;
import java.sql.*;
import java.util.*;

//TO ASSIGN A ROOOM AND UPDATE ITS NO OF BEDS
public class Room {
	private int roomId;
	private String deptId;
	private String roomType;
	private double roomcost;
	private int noOfBeds;
	private int duration;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(double roomcost) {
		this.roomcost = roomcost;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Room(int roomId, String deptId, String roomType, double roomcost,
			int noOfBeds, int duration) {
		super();
		this.roomId = roomId;
		this.deptId = deptId;
		this.roomType = roomType;
		this.roomcost = roomcost;
		this.noOfBeds = noOfBeds;
		this.duration = duration;
	}
	public Room(String deptId, String roomType) {
		super();
		this.deptId = deptId;
		this.roomType = roomType;
	}
	
	//FUNCTION TO ASSIGN A ROOM TO THE INPATIENT
	public ArrayList<String> assignRoom(Room r) 
	{
		
		ArrayList<String> rlist=new ArrayList<String>();
		String deptid=r.getDeptId();
		String roomtype=r.getRoomType();
		 DBConnection database=new DBConnection();
			Connection con=database.getConnection();
		ResultSet rs=null;
		if(con!=null)
		{
			System.out.println("connection done");
		}
		else
		{
			System.out.println("connection not done");
		}
		PreparedStatement pstmt=null;
		String sql="SELECT ROOMID,DEPTID,COST FROM ROOM WHERE (DEPTID=? AND ROOMTYPE=?)";
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
		
			System.out.println("statement not prepared");
		}
		try{
			String rId;
			String dId;
			String cost;
			pstmt.setString(1,deptid);
			pstmt.setString(2,roomtype);
			rs=pstmt.executeQuery();
			
		while(rs.next())
		{	     rId=Integer.toString(rs.getInt(1));
			     dId=rs.getString(2);
			    cost=Integer.toString(rs.getInt(3));
				
				
		
			rlist.add(rId);
		    rlist.add(dId);
		    rlist.add(cost);
		}
		}
		catch(Exception e)
		{
			System.out.println("Query not executed");
		}
		
		return rlist;
	
	
	}
	
	//AFTER ASSIGNING A ROOM NO OF BEDS ARE UPDATED 
	public String updateRoomDetails(ArrayList<String> r)
	{
		int roomid=Integer.parseInt(r.get(0));
		 DBConnection database=new DBConnection();
			Connection con=database.getConnection();
		PreparedStatement pstmt=null;
		String sql="UPDATE ROOM SET NOOFBEDS=(NOOFBEDS-1) WHERE ROOMID=?";
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
		System.out.println("statement not prepared");
		}
		try {
			pstmt.setInt(1,roomid);
			int num=pstmt.executeUpdate();
		} catch (SQLException e) {
		System.out.println("query not executed");
		}
		
		return ("details updated");
		
		
	}
	

}
