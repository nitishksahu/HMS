<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discharge Card</title>
<%@ include file="css/style.css" %>
</head>
<body id="body">
<%Discharge obj=(Discharge)request.getAttribute("discharge"); %>
<%@page import="com.hms.model.*,java.util.*" %>
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2"><h2>DISCHARGE CARD</h2></th>
</tr>
<tr>
<td>
OPD NO: </td><td><%=obj.getOpdno()%>
</td>
</tr>
<tr>
<td>
DISCHARGE DATE:</td><td> <%=obj.getDisdate()%>
</td>
</tr>
<tr>
<td>
DISCHARGE TIME:</td><td> <%=obj.getDistime()%>
</td>
</tr>


</table>
<a href ="index.jsp">Home</a>
</body>
</html>