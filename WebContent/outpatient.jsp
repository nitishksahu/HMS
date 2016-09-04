<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Out Patient Details</title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>
</head>
<body id="body">
<form name="fg" method="post" action="/HMS3/Controller">
<table id="mytable" class="styleTable" align="center">

	<tr>
		<td colspan="2">
		<h1><marquee>PATIENT DETAILS</marquee></h1>
		</td>
	</tr>

	<tr>
		<td>OPD No:</td><td> <input type="text" name="opdno" value="${p.OPDNo}" onFocus="this.blur()"/></td>
	</tr>
	<tr>
		<td>First Name* : </td><td><input type="text" name="fname" maxlength="15"
			value="${p.firstName}" onFocus="this.blur()"/></td>
	</tr>

	<tr>
		<td>Last Name* :</td><td><input type="text" name="lname" maxlength="15"
			value="${p.lastName}"onFocus="this.blur()"><br></br>
		</td>
	</tr>

	<tr>
		<td>Middle Name :</td><td><input type="text" name="mname" maxlength="15"
			value="${p.middleName}" onFocus="this.blur()"><br></br>
		</td>
	</tr>

	<tr>
		<td>Address*:</td><td><input type="text" name="text" value="${p.address}" onFocus="this.blur()"><br></br>
		</td>
	</tr>

	<tr>
		<td>Email* :</td><td> <input type="text" name="email" value="${p.emailID}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>

	<tr>
		<td>DateOfBirth*:</td><td><input type="text" name="dob"
			value="${p.dateOfBirth}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>


	<tr>
		<td>Gender*: </td><td><input type="text" name="sex" value="${p.gender}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>


	<tr>
		<td>Blood Group*:</td><td> <input type="text" name="groups"
			value="${p.bloodGroup}" onFocus="this.blur()"> <br>
		<br />
		</td>
	</tr>

	<tr>
		<td>Visited Earlier*:</td><td><input type="text" name="check"
			value="${p.visitedEarlier}" onFocus="this.blur()"/></td>
	</tr>


	<tr>
		<td>Father/spouse Name* : </td><td><input type="text" name="sname"
			maxlength="30" value="${p.guardianName}"onFocus="this.blur()"/><br>
		<br />
		</td>
	</tr>


	<tr>
		<td>ContactNo*:</td><td><input type="text" name="contactno" maxlength="10"
			value="${p.OPDNo}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>

	<tr>
		<td>DeptID*:</td><td><input type="text" name="deptid" maxlength="10"
			value="${p.deptID}" onFocus="this.blur()"/></td>
	</tr>
	<tr>
		<td>Room ID* :</td><td><input type="text" name="roomid" maxlength="10"
			value="${p.roomID}" ><br></br>
		</td>
	</tr>

	<tr>
		<td>Bed NO* :</td><td><input type="text" name="bedno" maxlength="10"
			value="${p.bedNo}" ><br></br>
		</td>
	</tr>

	<tr>
		<td>Admit Date*:</td><td><input type="text" name="ad"
			value="${p.admitDate}" onFocus="this.blur()" /><br></br>
		</td>
	</tr>

	<tr>
		<td>Room Type:</td><td><input type="text" name="rt" value="${p.roomType}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>

	<tr>
		<td>Discharge Date*:</td><td><input type="text" name="dd"
			value="${p.dischargeDate}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>

	<tr>
		<td>DeptName:</td><td><input type="text" name="dn" value="${p.deptName}" onFocus="this.blur()"/><br></br>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="update" /></td><td> <input type="reset"
			value="reset" /></td>
	</tr>
	<tr>
	<td><input type="hidden" name="action" value="displayPatient"></input></td>
	</tr>
</table>
${s}</form>
<a href ="index.jsp">Home</a>-><a href ="main.jsp">SearchOPD</a>
</body>

</html>