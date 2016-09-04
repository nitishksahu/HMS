package com.hms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//for searching a schedule of doctor with the patient
public class Appointment {
	private int appointmentId;
	private int opdNumber;
	private int doctorId;
	private String visitingDate;
	private String visitingTimeFrom;
	private String visitingTimeTo;
	private String doctorObservation;
	
	private String needRoom;
	
	public Appointment(int appointmentId, int opdNumber, int doctorId,
			String visitingDate, String visitingTimeFrom,
			String visitingTimeTo, String doctorObservation,
			String needRoom) 
	{
	
		this.appointmentId = appointmentId;
		this.opdNumber = opdNumber;
		this.doctorId = doctorId;
		this.visitingDate = visitingDate;
		this.visitingTimeFrom = visitingTimeFrom;
		this.visitingTimeTo = visitingTimeTo;
		this.doctorObservation = doctorObservation;
		
		this.needRoom = needRoom;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getOpdNumber() {
		return opdNumber;
	}

	public void setOpdNumber(int opdNumber) {
		this.opdNumber = opdNumber;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getVisitingDate() {
		return visitingDate;
	}

	public void setVisitingDate(String visitingDate) {
		this.visitingDate = visitingDate;
	}

	public String getVisitingTimeFrom() {
		return visitingTimeFrom;
	}

	public void setVisitingTimeFrom(String visitingTimeFrom) {
		this.visitingTimeFrom = visitingTimeFrom;
	}

	public String getVisitingTimeTo() {
		return visitingTimeTo;
	}

	public void setVisitingTimeTo(String visitingTimeTo) {
		this.visitingTimeTo = visitingTimeTo;
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

	//SEARCH THE DETAILS OF THE SCHEDULED APPOINTMENT CORRESPONDING TO THE OPD NO PROVIDED
	public static ArrayList<Appointment> searchopdnumber(int opd)
	{
	DBConnection database=new DBConnection();
	Connection con=database.getConnection();
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="select * from Appointment where OPDNO=?";
	try
	{
	pstmt = con.prepareStatement(sql);
	}
	catch(Exception e)
	{
		System.out.println("Prepared Statement creation failed");
	}
	try {
		pstmt.setInt(1, opd);
	} 
	catch (SQLException e1) {
		System.out.println("Dynamic values not set");
	}
	
	try
	{
	rs = pstmt.executeQuery();
	}
	catch(Exception e)
	{
		System.out.println("Query not executed");
	}
	ArrayList<Appointment> searchResult=new ArrayList<Appointment>();
	try
	{
		while(rs.next())
		{
		
		 int appointmentId=rs.getInt("APPOINTMENTID");
		 int opdNumber=rs.getInt("OPDNO");
		 int doctorId=rs.getInt("DOCTORID");
		 String visitingDate=rs.getString("VISITINGDATE");
		 String visitingTimeFrom=rs.getString("VISITINGTIMEFROM");
		 String visitingTimeTo=rs.getString("VISITINGTIMETO");
		 String doctorObservation=rs.getString("DOCTOROBSERVATION");
		 String needRoom=rs.getString("NEEDROOM");
		 Appointment appointmentobject=new Appointment(appointmentId,opdNumber,doctorId,
				 visitingDate,visitingTimeFrom, visitingTimeTo,doctorObservation,
				 needRoom);
		 searchResult.add(appointmentobject);
		}
		
	}
	catch(Exception e)
	{
	e.printStackTrace();
		System.out.println("Unable to retrieve values from Appointment table");
	}
	finally
	{
		try{
		rs.close();
		pstmt.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Unable to close resources");
		}
	}
		
	return searchResult;
	}

}


