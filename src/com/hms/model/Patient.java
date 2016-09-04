package com.hms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



//SEARCHING FOR A PATIENT AND TRANSFERING HIM FROM ONE ROOM TO ANOTHER
public class Patient {
	
	private int OPDNo;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private String emailID;
	private String dateOfBirth;
	private String gender;
	private String bloodGroup;
	private String visitedEarlier;
	private String guardianName;
	private int contactNumber;
	private String deptID;
	private int roomID;
	private int bedNo;
	private String admitDate;
	private String dischargeDate;
	private String roomType;
	private String deptName;
	
	public Patient()
	{
		
	}
	public Patient(int OPDNo, String firstName, String lastName,
			String middleName, String address, String emailID,String dateOfBirth, String gender,
			String bloodGroup, String visitedEarlier, String guardianName,int contactNumber) {

		this.OPDNo = OPDNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.address = address;
		this.emailID = emailID;
		this.dateOfBirth=dateOfBirth;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.visitedEarlier = visitedEarlier;
		this.guardianName = guardianName;
		this.contactNumber=contactNumber;
	}
	public Patient(int OPDNo, String deptID, int roomID, int bedNo,String admitDate,String dischargeDate) {
		this.OPDNo = OPDNo;
		this.deptID = deptID;
		this.roomID = roomID;
		this.bedNo = bedNo;
		this.admitDate=admitDate;
		this.dischargeDate=dischargeDate;
	}
	
	public int getOPDNo() {
		return OPDNo;
	}
	public void setOPDNo(int oPDNo) {
		OPDNo = oPDNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getVisitedEarlier() {
		return visitedEarlier;
	}
	public void setVisitedEarlier(String visitedEarlier) {
		this.visitedEarlier = visitedEarlier;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDeptID() {
		return deptID;
	}
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
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
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	//SELECT OUTPATIENT DETAILS,INPATIENT DETAILS,ROOMTYPE,DEPARTMENT CORRESPONDING TO THE OPD NO
	public Patient searchPatient(int OPDNo)
	{
		DBConnection demo = new DBConnection();
		demo.getConnection();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		ResultSet j=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		ResultSet rs2=null;
		Patient p=new Patient();
		try 
		{
			
			conn = demo.getConnection();
			if(conn!=null)
				System.out.println("Connection done");
			else
				System.out.println("Connection not done");
			try
			{
				pstmt = conn.prepareStatement("SELECT * FROM OUTPATIENT WHERE OPDNO=?");
				pstmt.setInt(1,OPDNo);
				rs = pstmt.executeQuery();
			}
			catch(Exception e)
			{
				System.out.println("Prepared Statement1 creation failed");
			}
			try
			{
				pstmt1 = conn.prepareStatement("SELECT * FROM INPATIENT WHERE OPDNO=?");
				pstmt1.setInt(1,OPDNo);
				rs1 = pstmt1.executeQuery();
				String sql1="SELECT ROOMTYPE FROM ROOM R, INPATIENT I WHERE R.ROOMID=I.ROOMID AND I.OPDNO=?";
				pstmt2 = conn.prepareStatement(sql1);
				pstmt2.setInt(1,OPDNo);
				rs2=pstmt2.executeQuery();
				
				String sql2="SELECT DEPTNAME FROM DEPARTMENT D,INPATIENT I WHERE D.DEPTID=I.DEPTID AND I.OPDNO=?";
				pstmt3 = conn.prepareStatement(sql2);
				pstmt3.setInt(1,OPDNo);
				j=pstmt3.executeQuery();
				
			}
			catch(Exception e)
			{
				System.out.println("Prepared Statement2 creation failed");
			}
			
			while(rs.next())
			{
				if(rs.getInt("OPDNO")==(OPDNo))
				{
					Integer OPDNo1 = rs.getInt("OPDNO");
					String firstName = rs.getString("FIRSTNAME");
					String lastName = rs.getString("LASTNAME");
					String middleName = rs.getString("MIDDLENAME");
					String address = rs.getString("ADDRESS");
					String emailID = rs.getString("EMAILID");
					String dateOfBirth=rs.getString("DATEOFBIRTH");
					String gender = rs.getString("GENDER");
					String bloodGroup = rs.getString("BLOODGROUP");
					String visitedEarlier = rs.getString("VISITEDEARLIER");
					String guardianName = rs.getString("GUARDIANNAME");
					p.setOPDNo(OPDNo1);
					p.setFirstName(firstName);
					p.setLastName(lastName);
					p.setMiddleName(middleName);
					p.setAddress(address);
					p.setEmailID(emailID);
					p.setDateOfBirth(dateOfBirth);
					p.setGender(gender);
					p.setBloodGroup(bloodGroup);
					p.setVisitedEarlier(visitedEarlier);
					p.setGuardianName(guardianName);
					

				}
			
				
			}
			if(rs1!=null)
			{
				while(rs1.next())
				{
					if(rs1.getInt("OPDNO")==(OPDNo))
					{
						
						String deptID = rs1.getString("DEPTID");
						Integer roomID = rs1.getInt("ROOMID");
						Integer bedNo = rs1.getInt("BEDNO");
						String admitDate=rs1.getString("ADMITDATE");
						String dischargeDate=rs1.getString("DISCHARGEDATE");
						p.setDeptID(deptID);
						p.setRoomID(roomID);
						p.setBedNo(bedNo);
						p.setAdmitDate(admitDate);
						p.setDischargeDate(dischargeDate);
						while(rs2.next()){
							System.out.println("sd");
							p.setRoomType(rs2.getString("ROOMTYPE"));
						}
						
						while(j.next()){
							System.out.println("dept");
							p.setDeptName(j.getString("DEPTNAME"));
						}
			
						
					}
				
				}
			}
		    rs.close();
		    pstmt.close();
		    rs1.close();
		    pstmt1.close();
		    pstmt2.close();
		    pstmt3.close();
		    rs2.close();
		    j.close();
		}catch(Exception e) {
			System.out.println(" Exception"+e);
		}
		finally
		{
			try{
				if(pstmt!=null)
					pstmt.close();
				if(pstmt1!=null)
					pstmt1.close();
				if(rs!=null)
					rs.close();
				if(rs1!=null)
					rs1.close();
				}
				
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return p;
	}
	
	//FUNCTION FOR TRANSFERING A PATIENT
	public int transferPatient(int op,int rno, int bno)
	{
		DBConnection demo = new DBConnection();
		demo.getConnection();
		int i=0;
		Connection conn = null;
	    PreparedStatement pstmt1=null;
	    PreparedStatement pstmt2=null;
		conn = demo.getConnection();
		try
		{
			String sql = "UPDATE INPATIENT SET ROOMID=?,BEDNO=? WHERE OPDNO=?";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setInt(1, rno);
			pstmt1.setInt(2, bno);
			pstmt1.setInt(3, op);
			i = pstmt1.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

		   
		finally
		{
			try{
				if(pstmt1!=null)
					pstmt1.close();
				if(pstmt2!=null)
					pstmt2.close();
				}
				
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return i;
		}		
}



