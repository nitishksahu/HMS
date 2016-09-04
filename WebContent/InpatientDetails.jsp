<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inpatient Details</title>
<%@ include file="css/style.css" %>
</head>
<body id="body">
<form name="f2" action="/HMS3/Controller" method="post">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2">INPATIENT DETAILS</th>
</tr>
<tr>
<td>
Enter OPD no : 
</td>
<td><input type=text name=opdnum></td>
</tr>
<tr>
<td>
Enter Department Id : 
</td>
<td><input type=text name=depid></td>
</tr>
<tr>
<td>
Enter Room Id : 
</td>
<td><input type=text name=roomid></td>
</tr>
<tr>
<td>
Enter Bed no : 
</td>
<td><input type=text name=bedno></td>
</tr>
<tr>
<td>
Enter Admit Date : 
</td>
<td><input type=text name=admitdate></td>
</tr>

<tr>
<td>
Enter Duration : 
</td>
<td><input type=text name=duration></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="submit" value="Record Patient Details">
</td>
</tr>
<tr>
<td><input type="hidden" name="action" value="inpatientregister"></td>
</tr>









</table>


</form>
<a href ="index.jsp">Home</a>
-><a href ="ward.jsp">AllocateRoom</a>
-><a href ="home.jsp">SearchPatient</a>
</body>
</html>