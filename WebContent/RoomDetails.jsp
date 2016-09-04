<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Allocating Room</title>
<%@ include file="css/style.css" %>
</head>
<body id="body">
<form name="f1" method="get" action="/HMS3/Controller">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2"><h2>ENTER ROOM DETAILS</h2></th>
</tr>

<tr><td>
Enter Department ID<br></br><input type=text name=deptId></input><br></br></td></tr>
<tr><td>Enter Room Type<br></br><input type=text name=roomtype></input><br></br></td></tr>
<tr><td><center><input type="submit" value="Allocate"></input></center></td></tr>
<tr>
<td>
<input type=hidden name="action" value="allocate"></input>
</td>
</tr>
</table>
</form>
<a href ="index.jsp">Home</a>
-><a href ="ward.jsp">AllocateRoom</a>
-><a href ="home.jsp">SearchPatient</a>
-><a href ="details.jsp">Back</a>
</body>
</html>