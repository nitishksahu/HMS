<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Details</title>
<%@ include file="css/style.css" %>
</head>
<body id="body">
<%@page import="com.hms.model.*,java.util.*"%>
<% ArrayList<String> roomSet=(ArrayList<String>)request.getAttribute("roomallocated"); %>
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2"><h2>ROOM DETAILS</h2></th>
</tr>
<tr>
<td>
ROOM ID : </td><td><%=roomSet.get(0) %>
</td>
</tr>
<tr>
<td>
DEPARTMENT ID :</td><td> <%=roomSet.get(1)%>
</td>
</tr>
<tr>
<td>
COST :</td><td> <%=roomSet.get(2)%>
</td>
</tr>
</table>
<h3><a href="InpatientDetails.jsp">Proceed</a></h3>
<a href ="index.jsp">Home</a>
</body>
</html>