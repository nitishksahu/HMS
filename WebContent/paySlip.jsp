<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.hms.model.Payment;" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Slip</title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>
</head>
<body id="body">

<%Payment pay=(Payment)request.getAttribute("PAY"); %>


<table id="mytable" class="styleTable" align="center" >


<% 
try
	{	%>
	<tr>
	<th colspan="2" ><h1>PAY SLIP</h1></th>
	</tr>
			<tr>
			<td colspan="2" align="center"><h3>Billing Information</h3></td>
			</tr>
			<tr>
				<td>PAYMENT ID</td>
				<td><%= pay.getPaymentId() %></td>
			</tr>
			
			<tr>
			<td>PAYMENT DONE FOR OPD NUMBER</td>
			<td>
			<%=pay.getOpdNo() %></td>
			</tr>
			
			<tr>
			<td>AMOUNT RECIEVED</td>
			<td><%=pay.getAmount() %></td>
			</tr>
			
			
			<tr>
			<td>PAYMENT DATE</td>
			<td><%=pay.getPaymentDate() %></td>
			</tr>
			
			<tr>
			<td>PAYMENT MODE</td>
			<td><%=pay.getPaymentMode() %></td>
			</tr>
			
	<%	
	}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Result not printed");
		}%>
</table>
<a href ="index.jsp">Home</a>
</body>
</html>