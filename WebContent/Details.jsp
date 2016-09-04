

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
<%@ include file="css/style.css" %>
</head>
<body id="body">
<%@page import="com.hms.model.*;" %>
<% Outpatient record=(Outpatient)request.getAttribute("ResultList"); %>
<table id="mytable" class="styleTable" align="center">
<tr>
<td>
OPD NUMBER : </td><td><%= record.getOpdno() %>
</td>
</tr>
<tr>
<td> NAME : </td><td>
<%= record.getFname()%> <%= record.getMname()%> <%= record.getLname()%>
</td>
</tr>
<tr>
<td>
BLOOD GROUP :</td><td> <%= record.getBloodGrp()%>
</td>
</tr>
<tr>
<td>
VISITED EARLIER :</td><td> <%=record.getVisitedEarlier()%>
</td>
</tr>
<tr>
<td>
DOCTOR OBSERVATION :</td><td> <%=record.getDoctorObservation() %>
</td>
</tr>

<tr>
<td>
NEED ROOM : </td><td><%=record.getNeedRoom() %>

</td>
</tr>
</table>

<center><a href="RoomDetails.jsp">ALLOCATE</a></center><br></br>
<center><a href="Home.jsp">CANCEL</a></center>
<a href ="index.jsp">Home</a>
-><a href ="ward.jsp">AllocateRoom</a>
-><a href ="home.jsp">SearchPatient</a>
</body>
</html>