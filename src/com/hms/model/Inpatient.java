package com.hms.model;
import java.sql.*;

//REGISTERING AN INPATIENT
public class Inpatient {

	private int opdno;
	private String deptId;
	private int roomId;
	private int bedNo;
	private String admitDate;
	private String discDate;
	private int duration;
	
	public int getOpdno() {
		return opdno;
	}
	public void setOpdno(int opdno) {
		this.opdno = opdno;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	public String getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}
	public String getDiscDate() {
		return discDate;
	}
	public void setDiscDate(String discDate) {
		this.discDate = discDate;
	}
	
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Inpatient(int opdno, String deptId, int roomId, int bedNo,
			String admitDate, String discDate,int duration) {
		super();
		this.opdno = opdno;
		this.deptId = deptId;
		this.roomId = roomId;
		this.bedNo = bedNo;
		this.admitDate = admitDate;
		this.discDate = discDate;
		this.duration=duration;
		
	}
	
	//FUNCTION FOR REGISTERING AN INPATIENT
	public int registerInpatient(Inpatient p)
	{
		int num=0;
		
		PreparedStatement pstmt=null;
		 DBConnection database=new DBConnection();
			Connection con=database.getConnection();
		if(con!=null)
		{
			System.out.println("connection done");
		}
		else
		{
			System.out.println("connection not done");
		}
		String sql="INSERT INTO INPATIENT(OPDNO,DEPTID,ROOMID,BEDNO,ADMITDATE,DISCHARGEDATE,DURATION)VALUES(?,?,?,?,TO_DATE(?,'DD-MM-YYYY'),TO_DATE(?,'DD-MM-YYYY'),?)";
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
			
			System.out.println("statement not created");
		}
		try {
			pstmt.setInt(1,p.getOpdno());
			pstmt.setString(2,p.getDeptId());
			pstmt.setInt(3,p.getRoomId());
			pstmt.setInt(4,p.getBedNo());
			pstmt.setString(5,p.getAdmitDate());
			pstmt.setString(6,p.getDiscDate());
			pstmt.setInt(7,p.getDuration());
			
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Query not executed");
		}
		return num;
		
	}
	
	
	
	
	
	
}
