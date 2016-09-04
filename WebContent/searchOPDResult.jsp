<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search OPD </title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>
</head>
<body id="body">
<script type="text/javascript" src="javascript/searchOpdCanteenCharge.js"></script>
<%@ page import="com.hms.model.Appointment"  %>
<%@ page import ="java.util.ArrayList" %>
<%
ArrayList<Appointment> searchOpdResult=(ArrayList<Appointment>)request.getAttribute("searchResult");
Object ofee=request.getAttribute("FEE");
String sfee = ofee.toString(); 
double fee = Double.valueOf(sfee).doubleValue();
Object oopd=request.getAttribute("opd");
String sopd = oopd.toString(); 
int opd = Integer.parseInt(sopd);


%>
<form name="payment" action="/HMS3/Controller" method="post" onSubmit="return checkcanteencharge()">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="8"><h2>PATIENT DETAILS</h2></th>
</tr>
<tr>
<th colspan="4">PAYMENT ON GOING FOR OPD NUMBER</th>
<th colspan="4"><input type="text"  name="opd" value=<%=opd %> onFocus="this.blur()"></input></th>
</tr>
<tr>
<td>APPOINTMENT ID</td>
<td>OPD NUMBER</td>
<td>DOCTOR ID</td>
<td>VISITING DATE</td>
<td>VISITING TIME FROM</td>
<td>VISITING TIME TO</td>
<td>DOCTOR OBSERVATION</td>
<td>NEED ROOM</td>
</tr>

<% 
try
	{
	for(Appointment a: searchOpdResult)
		{
			%>
			<tr>
			<td><%=a.getAppointmentId()%></td>
			
			<td><%=a.getOpdNumber() %></td>
			
			<td><%=a.getDoctorId() %></td>
			<td><%=a.getVisitingDate() %></td>
			<td><%=a.getVisitingTimeFrom() %></td>
			<td><%=a.getVisitingTimeTo() %></td>
			
			<td><%=a.getDoctorObservation() %></td>
			
			<td><%=a.getNeedRoom() %></td>
			</tr>
	<%	}
	}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Result not printed");
		}%>
</table>


<br>
<br>

<table align="center">
<tr>
<td><h5>TOTAL AMOUNT TO BE PAID IS =</h5></td>
<td><input type="text" value="<%=fee %>" onFocus="this.blur()"></input></td>
</tr>

<tr>
<td>Please Enter Canteen Charge (if any)</td>
<td><input type="text" name="canteenCharge"></input></td>
</tr>

<tr>
<td><input type="hidden" name="cost" value=<%=fee %>></input></td>
</tr>

<tr>
<td><input type="hidden" name="action" value="pay"></input></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="PAY"></input></td>
</tr>




</table>
<a href ="index.jsp">Home</a>-><a href ="searchpatientappointment.jsp">searchOPD</a>
</form>
</body>
</html>