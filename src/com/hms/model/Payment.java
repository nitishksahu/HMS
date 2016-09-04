package com.hms.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//CALCULATE,VIEW ALL THE PAYMENTS FOR INPATIENT OR OUTPATIENT
public class Payment {
	
	int paymentId;
	int opdNo;
	double amount;
	String paymentDate;
	String paymentMode;
	
	public Payment(int paymentId, int opdNo, double amount, String paymentDate,
			String paymentMode) {
		super();
		this.paymentId = paymentId;
		this.opdNo = opdNo;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
	}
	public Payment(int opdNo,double amount, String paymentDate,
			String paymentMode) {
		this.opdNo=opdNo;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		System.out.println("payment object created");
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getOpdNo() {
		return opdNo;
	}
	public void setOpdNo(int opdNo) {
		this.opdNo = opdNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
//CALCULATE DOCTOR CONSULTATION FEE FOR OUTPATIENT AND ROOM	COST,MEDICINE COST,DURATION
	public static double calculateAmount(int opd)
	{
		
	double totalFee=0.0;
	double totalOutPatientFee=0.0;
	double totalInPatientFee=0.0;
	double roomCost=0.0,totalMedicineCost=0.0;
	int duration=0,medicineQuantity=0;
	double medicineCost=0.0;
DBConnection database=new DBConnection();
Connection con=database.getConnection();
PreparedStatement pstmtInPatientRoomCost=null;
PreparedStatement pstmtInPatientRoomDuration=null;
ResultSet rsInPatientRoomDuration=null;
PreparedStatement pstmtCheckAllocation=null;
PreparedStatement pstmtGetDoctorFee=null;
ResultSet rsCheckAllocation=null;
ResultSet rsCalculateFee=null;
ResultSet rsInPatientRoomCost=null;
PreparedStatement pstmtMedicineCost=null;
ResultSet rsMedicineCost=null;
PreparedStatement pstmtCheckPrevoiusPayment=null;
ResultSet rsCheckPrevoiusPayment=null;



//CHECKING FOR PRE PAYMENR DONE OR NOT

String sql="SELECT * FROM PAYMENT WHERE OPDNO=?";

try
{
 pstmtCheckPrevoiusPayment = con.prepareStatement(sql);
}
catch(Exception e)
{
	System.out.println("Prepared Statement creation failed");
}
try {
	pstmtCheckPrevoiusPayment.setInt(1, opd);
} 
catch (SQLException e1) {
	System.out.println("Dynamic values not set");
}

try
{
	rsCheckPrevoiusPayment = pstmtCheckPrevoiusPayment.executeQuery();
}
catch(Exception e)
{
	System.out.println("Query not executed");
}
int newopd=0;
try {
	while(rsCheckPrevoiusPayment.next())
	{
	newopd = rsCheckPrevoiusPayment.getInt("OPDNO");
	}
} catch (SQLException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
if(newopd==opd)
{
	return 0.0;
}
else
{



//CHECKING ALLOCATION TO KNOW THE TYPE OF PATIENT(IN/OUT)

String sql1="select NEEDROOM from Appointment where OPDNO=?";
try
{
	pstmtCheckAllocation = con.prepareStatement(sql1);
}
catch(Exception e)
{
	System.out.println("Prepared Statement creation failed");
}
try {
	pstmtCheckAllocation.setInt(1, opd);
} 
catch (SQLException e1) {
	System.out.println("Dynamic values not set");
}

try
{
	rsCheckAllocation = pstmtCheckAllocation.executeQuery();
}
catch(Exception e)
{
	System.out.println("Query not executed");
}

try
{
	
	
	while(rsCheckAllocation.next())
	{
	System.out.println("Inside While");
	
	
	
	
	
	
	
	//INPATIENT AMOUNT CALCULATION
	 if((rsCheckAllocation.getString("NEEDROOM").equalsIgnoreCase("YES")))
	 {
		 			
		 //CALCULATING ROOM COST
		 
		sql="Select R.COST from ROOM R,INPATIENT IP where R.ROOMID=IP.ROOMID AND OPDNO=?";
		try
		{
			pstmtInPatientRoomCost=con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			System.out.println("In Patient prepared statement not created");
		}
		try
		{
			pstmtInPatientRoomCost.setInt(1, opd);
		}
		catch(Exception e)
		{
			System.out.println("Dynamic values not set");
		}
		try
		{
			rsInPatientRoomCost=pstmtInPatientRoomCost.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Resultset not fetched");
		}
		if(rsInPatientRoomCost.next())
		{
			roomCost=rsInPatientRoomCost.getDouble("COST");
		System.out.println("ROOM COST"+rsInPatientRoomCost.getDouble("COST"));
		System.out.println("Value at variable roomCost is:"+roomCost);
		}
		
		
		
		
		
		//CALCULATING DURATION OF STAY
		sql="SELECT (DISCHARGEDATE-ADMITDATE) AS DURATION FROM INPATIENT WHERE OPDNO=?";
		try
		{
			pstmtInPatientRoomDuration=con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			System.out.println("In Patient prepared statement not created");
		}
		try
		{
			pstmtInPatientRoomDuration.setInt(1, opd);
		}
		catch(Exception e)
		{
			System.out.println("Dynamic values not set");
		}
		try
		{
			rsInPatientRoomDuration=pstmtInPatientRoomDuration.executeQuery();
			
		}
		catch(Exception e)
		{
			System.out.println("Resultset not fetched");
		}
		if(rsInPatientRoomDuration.next())
		{
			duration=rsInPatientRoomDuration.getInt("DURATION");
		System.out.println("ROOM Duration "+rsInPatientRoomDuration.getInt("DURATION"));	
		System.out.println("Duration after storing: "+duration);
		}
		
		
		
		
		//CALCULATING MEDICINE COST
		
		sql="SELECT COST,QUANTITY FROM MEDICINE WHERE OPDNO=?";
		try
		{
			pstmtMedicineCost=con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			System.out.println("In Patient prepared statement not created");
		}
		try
		{
			pstmtMedicineCost.setInt(1, opd);
		}
		catch(Exception e)
		{
			System.out.println("Dynamic values not set");
		}
		try
		{
			rsMedicineCost=pstmtMedicineCost.executeQuery();
			
		}
		catch(Exception e)
		{
			System.out.println("Resultset not fetched");
		}
		while(rsMedicineCost.next())
		{
			medicineCost=rsMedicineCost.getDouble("COST");
			System.out.println("Cost Of medidine: "+medicineCost);
			medicineQuantity=rsMedicineCost.getInt("QUANTITY");
			System.out.println("Quantity of medicine: "+medicineQuantity);
			totalMedicineCost=totalMedicineCost+(medicineCost*medicineQuantity);
		}
		System.out.println("Total Medicine Cost: "+totalMedicineCost);
		
		System.out.println("Cost as In Patient");
		 totalInPatientFee=totalMedicineCost+(roomCost*duration);
		
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //OUTPATIENT AMOUNT CALCULATION
	 
	 else
	 {
		 System.out.println("IN else");
		 sql="select D.FEE from DOCTOR D,APPOINTMENT A Where A.DOCTORID=D.DOCTORID and OPDNO= ? ";
			try
			{
				pstmtGetDoctorFee = con.prepareStatement(sql);
			}
			catch(Exception e)
			{
				System.out.println("Prepared Statement creation failed");
			}
			try {
				pstmtGetDoctorFee.setInt(1,opd);
			} 
			catch (SQLException e1) {
				System.out.println("Dynamic values not set");
			}
			
			try
			{
				rsCalculateFee = pstmtGetDoctorFee.executeQuery();
				System.out.println("Query Executed");
			
													
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Query not executed");
			} 
			
			
			
			
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //RETURNING FINAL AMOUNT  CALCULATED VALUE
	
		 try
		 {
			 ArrayList<Double> amount=new ArrayList<Double>();
			 while(rsCalculateFee.next())
			 {
				 System.out.println(rsCalculateFee.getDouble("FEE"));
				 amount.add(rsCalculateFee.getDouble("FEE"));
				 
			 }
			 for( Double d: amount)
			 {
				 totalOutPatientFee=totalOutPatientFee+d.doubleValue();
			 }
			 break;
			 
			 
		 }
		 catch(Exception e){
			 System.out.println("Amount not calculated");
		 }
		 finally
		 {
			 try
				{
				rsCalculateFee.close();
				pstmtGetDoctorFee.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Unable to close resources");
				}
		 }
	
	}
	
}
catch(Exception e)
{
e.printStackTrace();
System.out.println("Unable to retrieve values from Appointment table");
}
finally
{
	try
	{
	rsCheckAllocation.close();
	pstmtCheckAllocation.close();
	con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Unable to close resources");
	}
}
	totalFee=totalOutPatientFee+totalInPatientFee;
	
return totalFee;

	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//INSERTING VALUES INTO PAYMENT TABLE IN DATABASE
	
	public int insert(Payment p)
	{
	
		System.out.println("INSIDE INSERT FUNCTION");
		Connection con=null;
		DBConnection database=new DBConnection();
		con=database.getConnection();
		if(con!=null)
		{
			System.out.println("Connection Created");
		}
		else
		{
			System.out.println("Connection Failure");
		}
		
		
		int num=0;
		PreparedStatement payStatement=null;
		
	    	
		String sql="insert into PAYMENT (PAYMENTID,OPDNO,AMOUNT,PAYMENTDATE,PAYMENTMODE) values (SEQ_PAYMENTID.NEXTVAL,?,?,to_date(?,'dd-mm-yyyy'),?)";
		try
		{
			payStatement = con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			System.out.println("Statement creation failed");
		}
		
		
	
		
		try {
			System.out.println("UPDATING DYNAMIC VALUES");
		
			payStatement.setInt(1,p.getOpdNo());
			
			payStatement.setDouble(2,p.getAmount());
			
			payStatement.setString(3,p.getPaymentDate());
			
			payStatement.setString(4,p.getPaymentMode());
		
			num=payStatement.executeUpdate();
			System.out.println("Number of rows effected " + num);
			
		}
			 	 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insertion failed");
		}	
		finally{
			try {
				payStatement.close();
				con.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("problem closing Prepared Statement");
				}
		}
		return num;
	
	}
	
	//insertToDatabase()	
	public ResultSet viewPaymentDetails()
	{
		PreparedStatement paymentDetails=null;
		ResultSet rsPaymentDetails=null;
		DBConnection database=new DBConnection();
		Connection con=database.getConnection();
		String sql="select * from PAYMENT";
		if(con!=null)
			System.out.println("Connection done");
		else
			System.out.println("Connection not done");
		try
		{
			paymentDetails = con.prepareStatement(sql);
		}
		catch(Exception e)
		{
			System.out.println("Prepared Statement creation failed");
		}
		try
		{
			rsPaymentDetails = paymentDetails.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Query not executed");
		}
		
		
		return rsPaymentDetails;
	}
	
	


}
