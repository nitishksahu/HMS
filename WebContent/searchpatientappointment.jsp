<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Patient</title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>
</head>
<body id="body">
<script type="text/javascript" src="javascript/validateopd.js"></script>
<form name="searchPatient" action="/HMS3/Controller" method="post" onSubmit="return checkopd()">
<table id="mytable" class="styleTable" align="center">
<tr>
<td colspan="2"><h2>Search For Appointment Details</h2><br></td>
</tr>

<tr>
<td>Enter OPD Number</td>
<td><input type="text" name="opd"></input></td>
</tr>
<tr>
</tr>

<tr>
</tr>

<tr align="center">
<td colspan="2"><input type="hidden" name="action" value="calculate"></input>
<input type="submit" value="Search Patient"></input></td>
</tr>
<a href ="index.jsp">Home</a>
</table>
</form>
</body>
</html>