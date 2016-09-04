package com.hms.controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.model.Appointment;
import com.hms.model.Discharge;
import com.hms.model.Inpatient;
import com.hms.model.Outpatient;
import com.hms.model.Patient;
import com.hms.model.Payment;
import com.hms.model.Room;
import com.hms.model.ValidateOpd;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action=request.getParameter("action");
		if((action!=null)&&action.equalsIgnoreCase("allocate"));
		{
			try
			{
			String deptid=request.getParameter("deptId");
			String roomtype=request.getParameter("roomtype");
			Room r=new Room(deptid,roomtype);
			ArrayList<String> roomset=r.assignRoom(r);
			String msg=r.updateRoomDetails(roomset);
			System.out.println(msg);
			request.setAttribute("roomallocated",roomset);
			RequestDispatcher reqDisp=request.getRequestDispatcher("Room.jsp");
			reqDisp.forward(request,response);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		double fee=0.0;
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("calculate"))
		{
			
			try
			{
			int opd=Integer.parseInt(request.getParameter("opd"));
		ArrayList<Appointment> searchResult=Appointment.searchopdnumber(opd);
		request.setAttribute("searchResult", searchResult);
		fee=Payment.calculateAmount(opd);
		if(fee==0.0)
		{
			RequestDispatcher reqDisp=request.getRequestDispatcher("paymentDone.jsp");
			reqDisp.forward(request,response);
		}
		else
		{
		request.setAttribute("FEE", fee);
		request.setAttribute("opd",opd);
		RequestDispatcher reqDisp=request.getRequestDispatcher("searchOPDResult.jsp");
		reqDisp.forward(request,response);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		else if(action.equalsIgnoreCase("pay"))
		{
			try
			{
			String fees=request.getParameter("cost");
			String opd=request.getParameter("opd");
			fee=Double.parseDouble(fees);
			System.out.println("Inside pay in controller");
			String canteenCharges=request.getParameter("canteenCharge");
			double canteenCharge=Double.parseDouble(canteenCharges);
			double costPayable=canteenCharge+fee;
			request.setAttribute("opd",opd);
			request.setAttribute("costPayable",costPayable);
			
			RequestDispatcher reqDisp=request.getRequestDispatcher("totalCost.jsp");
			reqDisp.forward(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(action.equalsIgnoreCase("payMode"))
		{
			try
			{
			String opd=request.getParameter("opd");
			String mode=request.getParameter("mode");
			System.out.println("MODE IS:"+mode);
			String cp=request.getParameter("costPayable");
			System.out.println("Cost Payable is:"+cp);
			request.setAttribute("costPayable",cp);
			request.setAttribute("mode",mode);
			request.setAttribute("opd",opd);
			if(mode.equalsIgnoreCase("cash"))
			{
				System.out.println("Insiude cash");
				RequestDispatcher reqDisp=request.getRequestDispatcher("cashPayment.jsp");
				reqDisp.forward(request,response);
			}
			else if(mode.equalsIgnoreCase("draft"))
			{
				RequestDispatcher reqDisp=request.getRequestDispatcher("draftPayment.jsp");
				reqDisp.forward(request,response);
			}
			else if(mode.equalsIgnoreCase("card"))
			{
				RequestDispatcher reqDisp=request.getRequestDispatcher("cardPayment.jsp");
				reqDisp.forward(request,response);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(action.equalsIgnoreCase("finalPay"))
		{
			try
			{
			System.out.println("inside final payment");
			String opds=request.getParameter("opd");
			int opd=Integer.parseInt(opds);
			String amounts=request.getParameter("amount");
			double amount=Double.valueOf(amounts);
			String mode=request.getParameter("mode");
			String date=request.getParameter("date");
			System.out.println("Mode is:"+mode+" date is: "+date);
			
			Payment pay=new Payment(opd,amount,date,mode);
			pay.insert(pay);
			ResultSet rs=pay.viewPaymentDetails();
			try
			{
			while(rs.next())
			{
				int paymentId=rs.getInt("PAYMENTID");
				int opdno=rs.getInt("OPDNO");
				double damount=rs.getDouble("AMOUNT");
				String paymentDate=rs.getString("PAYMENTDATE");
				String dmode=rs.getString("PAYMENTMODE");
				Payment pay1=new Payment(paymentId,opdno,damount,paymentDate,dmode);
				request.setAttribute("PAY", pay1);
				
			}
			RequestDispatcher reqDisp=request.getRequestDispatcher("paySlip.jsp");
			reqDisp.forward(request,response);
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Unable to retrive from result set");
			}
			finally
			{
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Not close rs in controller");
					e.printStackTrace();
				}
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("searchPatient"))
		{
			try
			{
			System.out.println("inside search patient");
		Patient p=new Patient();
		request.setAttribute("p",p.searchPatient(Integer.parseInt(request.getParameter("OPDNO"))));
		
		RequestDispatcher reqDisp1=request.getRequestDispatcher("outpatient.jsp");
		reqDisp1.forward(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(action.equalsIgnoreCase("displayPatient"))
		{
			try
			{
		int rno = Integer.parseInt(request.getParameter("roomid"));
		int bno = Integer.parseInt(request.getParameter("bedno"));
		int op = Integer.parseInt(request.getParameter("opdno"));
		Patient p1=new Patient();
		
		
		int i = p1.transferPatient(op,rno,bno);
		
		if(i==1)
			request.setAttribute("s","Success");
		else 
			request.setAttribute("s","Fail");
		
		RequestDispatcher reqDisp2=request.getRequestDispatcher("success.jsp");
		reqDisp2.forward(request,response);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
			
	//AMIT CONTROLLER
		
		else if(action!=null&&action.equalsIgnoreCase("discharge"))
		{
            int n=0;
			String opdno=request.getParameter("opdnum");
			int opdnum=Integer.parseInt(opdno);
			ArrayList <Integer> arr=ValidateOpd.Validate(opdnum);
			if(!(arr.isEmpty()))
			{
			String disdate=request.getParameter("disDate");
			String distime=request.getParameter("disTime");
			Discharge d=new Discharge(opdnum,disdate,distime);
			
			if(d.getDischargedate(d)==null)
			
				{
				n=d.discharge(d);
				String msg=d.updateRoom(d);
				
			System.out.println("Room updated");
				}
			else
			{
				System.out.println("patient already discharged");
				RequestDispatcher reqDisp=request.getRequestDispatcher("dischareged.jsp");
				reqDisp.forward(request,response);
			}
			if(n!=0)
			{
				request.setAttribute("discharge",d);
				RequestDispatcher reqDisp=request.getRequestDispatcher("DischargeCard.jsp");
				reqDisp.forward(request,response);
			
			}
			else if(arr.isEmpty())
			{
				RequestDispatcher reqDisp=request.getRequestDispatcher("IncorrectDetail.jsp");
				reqDisp.forward(request,response);
			}
			}
		}
		else if(action!=null&&action.equalsIgnoreCase("inpatientregister"))
		{
			
			String opdno=request.getParameter("opdnum");
			int opdnum=Integer.parseInt(opdno);
			ArrayList <Integer> arr=ValidateOpd.Validate(opdnum);
			try
			{
			if(!(arr.isEmpty()))
			{
			String deptid=request.getParameter("depid");
			int roomId=Integer.parseInt(request.getParameter("roomid"));
			int bednum=Integer.parseInt(request.getParameter("bedno"));
			String admitdate=request.getParameter("admitdate");	
			String dischargedate=request.getParameter("dischargedate");
			int duration=Integer.parseInt(request.getParameter("duration"));
			
			Inpatient inp=new Inpatient(opdnum,deptid,roomId,bednum,admitdate,dischargedate,duration);
			int num=inp.registerInpatient(inp);
			if(num!=0)
			{
			RequestDispatcher reqDisp=request.getRequestDispatcher("Registered.jsp");
			reqDisp.forward(request,response);
			}
			
			}
			
			else if(arr.isEmpty())
			{
				RequestDispatcher reqDisp=request.getRequestDispatcher("IncorrectDetail.jsp");
				reqDisp.forward(request,response);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(action!=null&&action.equalsIgnoreCase("view"))
		{
			
			String opdno=request.getParameter("opdnum");
			int opdnum=Integer.parseInt(opdno);
			ArrayList <Integer> arr=ValidateOpd.Validate(opdnum);
			if(!(arr.isEmpty()))
			{
			Outpatient obj=new Outpatient(opdnum);
			
			ResultSet rs= Outpatient.viewDetails(obj);
		try{
			while(rs.next())
			{ 
		 int opdNumber=rs.getInt(1);
		 String fname=rs.getString(2);
		String lname=rs.getString(3);
		 String mname=rs.getString(4);
		 String bloodgrp=rs.getString(5);
		 String visitedearlier=rs.getString(6);
		 String docObv=rs.getString(7);
		 String needRoom=rs.getString(8);
		Outpatient p=new Outpatient(opdNumber,fname,lname,mname,bloodgrp,visitedearlier,docObv,needRoom);
		request.setAttribute("ResultList",p);
}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher reqDisp=request.getRequestDispatcher("Details.jsp");
		reqDisp.forward(request,response);
		}
			else if(arr.isEmpty())
			{
				RequestDispatcher reqDisp=request.getRequestDispatcher("IncorrectDetail.jsp");
				reqDisp.forward(request,response);
			}
		}
		
		
		}
		
	
		
		
		
		
}

