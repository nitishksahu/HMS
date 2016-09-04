package com.hms.model;
import java.sql.*;
public class Discharge {
private int opdno;
private String disdate;
private String distime;

public int getOpdno() {
	return opdno;
}

public void setOpdno(int opdno) {
	this.opdno = opdno;
}

public String getDisdate() {
	return disdate;
}

public void setDisdate(String disdate) {
	this.disdate = disdate;
}


public String getDistime() {
	return distime;
}

public void setDistime(String distime) {
	this.distime = distime;
}

public Discharge(int opdno, String disdate, String distime) {
	super();
	this.opdno = opdno;
	this.disdate = disdate;
	this.distime = distime;
}

public Discharge(int opdno, String disdate) {
	super();
	this.opdno = opdno;
	this.disdate = disdate;
}


public Discharge(int opdno) {
	super();
	this.opdno = opdno;
}

public int discharge(Discharge d)
{
 int num=0;
 DBConnection database=new DBConnection();
	Connection con=database.getConnection();
 if(con!=null)
 {
	 System.out.println("connection done");
 }
 PreparedStatement pstmt=null;
 String sql="UPDATE INPATIENT SET DISCHARGEDATE=TO_DATE(?,'dd-mm-yyyy') WHERE OPDNO=?";
 
 try {
	pstmt=con.prepareStatement(sql);
} catch (SQLException e) {
	System.out.println("statement created");
}
 try
 {
	 pstmt.setString(1,d.getDisdate());
	 pstmt.setInt(2,d.getOpdno());
	 num=pstmt.executeUpdate();
 }
 catch(Exception e)
 {
	 System.out.println("Query not executed");
 }
 return num;
 
}

public String updateRoom(Discharge d)
{
	 DBConnection database=new DBConnection();
		Connection con=database.getConnection();
	if(con!=null)
	{
		System.out.println("Connection done");
	}
	else
	{
		System.out.println("not connected");
	}
	PreparedStatement pstmt=null;
	String sql="UPDATE room SET NOOFBEDS=(noofbeds+1) WHERE ROOMID IN (SELECT roomid FROM inpatient WHERE OPDNO=?)";
	try {
		pstmt=con.prepareStatement(sql);
	} catch (SQLException e) {
		System.out.println("Statement not prepared");
		e.printStackTrace();
	}
    try
    {
    	pstmt.setInt(1,d.getOpdno());
        int num=pstmt.executeUpdate(); 
    }
	catch(Exception e)
	{
		System.out.println("query not executed");
	}
	return "room updated";
	
	
	
}
public Date getDischargedate(Discharge d)
{
	Date discdate=null;
	ResultSet rs=null;
	DBConnection database=new DBConnection();
	Connection con=database.getConnection();
	String sql="SELECT DISCHARGEDATE FROM INPATIENT WHERE OPDNO=?";
	PreparedStatement pstmt=null;
	try {
		pstmt=con.prepareStatement(sql);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
   try {
	pstmt.setInt(1,d.getOpdno());
} catch (SQLException e) {
	
	e.printStackTrace();
}
   try {
	rs=pstmt.executeQuery();
} catch (SQLException e) {
	
	e.printStackTrace();
}
    try {
		while(rs.next())
		{
		  discdate=rs.getDate("DISCHARGEDATE");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

return discdate;

}















}