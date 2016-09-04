<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Valid OpdNumber</title>
<%@ include file="css/style.css" %>
<script type="text/javascript">
function validateForm()
{
//OPD No validation
var x=document.forms["form"]["OPDNO"].value;
	if(x=="")
	{
	alert("fill valid  opd number");
	return false;
	}
	else if(isNaN(x))
	{
	alert("enter numbers only");
	return false;
	}
}
</script>
</head>
<body id="body">
<form name="form" action="/HMS3/Controller"  method="post" onsubmit=" return validateForm()">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2"><h2>SEARCH PATIENT DETAILS</h2></th>
</tr>

<tr>
<td>OPD No: </td>
<td><input type="text" name="OPDNO" /></td>
</tr>
<tr>
<td>
<input type="hidden" name="action" value="searchPatient"></input></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="search for patient"/></td>
</tr>  
</table>
</form>
<a href ="index.jsp">Home</a>
</body>
</html>