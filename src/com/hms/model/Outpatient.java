package com.hms.model;
import java.sql.*;

//VIEW THE OUTPATIENT DETAILS CORRESPONDING TO THE OPD NO GIVEN
public class Outpatient {
	
private int opdno;
private String fname;
private String lname;
private String mname;
private String bloodGrp;
private String visitedEarlier;
private String doctorObservation;

private String needRoom;




	public int getOpdno() {
	return opdno;
}




public void setOpdno(int opdno) {
	this.opdno = opdno;
}




public String getFname() {
	return fname;
}




public void setFname(String fname) {
	this.fname = fname;
}




public String getLname() {
	return lname;
}




public void setLname(String lname) {
	this.lname = lname;
}




public String getMname() {
	return mname;
}




public void setMname(String mname) {
	this.mname = mname;
}




public String getBloodGrp() {
	return bloodGrp;
}




public void setBloodGrp(String bloodGrp) {
	this.bloodGrp = bloodGrp;
}




public String getVisitedEarlier() {
	return visitedEarlier;
}




public void setVisitedEarlier(String visitedEarlier) {
	this.visitedEarlier = visitedEarlier;
}




public String getDoctorObservation() {
	return doctorObservation;
}




public void setDoctorObservation(String doctorObservation) {
	this.doctorObservation = doctorObservation;
}









public String getNeedRoom() {
	return needRoom;
}




public void setNeedRoom(String needRoom) {
	this.needRoom = needRoom;
}




	public Outpatient(int opdno, String fname, String lname, String mname,
		String bloodGrp, String visitedEarlier, String doctorObservation, String needRoom) {
	
	this.opdno = opdno;
	this.fname = fname;
	this.lname = lname;
	this.mname = mname;
	this.bloodGrp = bloodGrp;
	this.visitedEarlier = visitedEarlier;
	this.doctorObservation = doctorObservation;
	
	this.needRoom = needRoom;
}




	public Outpatient(int opdno) {
		
		this.opdno = opdno;
	}




	//TO VIEW ALL THE DETAILS OF OUTPATIENT
	public static ResultSet viewDetails(Outpatient op)
	{
		DBConnection database=new DBConnection();
		Connection con=database.getConnection();
		if(con!=null)
			System.out.println("Connection done");
		else
			System.out.println("Connection not done");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT OP.OPDNO,OP.FIRSTNAME,OP.LASTNAME,OP.MIDDLENAME,OP.BLOODGROUP,OP.VISITEDEARLIER,A.DOCTOROBSERVATION,A.NEEDROOM FROM OUTPATIENT OP INNER JOIN APPOINTMENT A ON OP.OPDNO=A.OPDNO WHERE OP.OPDNO=?";
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
		    System.out.println("Statement creation failed");
			e.printStackTrace();
		}
		try {
			pstmt.setInt(1,op.getOpdno());
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
		
	   return rs;
			
			}
		}
	   
	
	


