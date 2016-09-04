<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discharging Patient</title>
<%@ include file="css/style.css" %>

</head>
<body id="body">
<script type=text/javascript src="javascript/javascript2.js"></script>
<form name="f3" action="/HMS3/Controller" method="post" onsubmit="return Validate()">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2"><h2>DISCHARGE PATIENT DETAILS</h2></th>
</tr>
<tr><td>
ENTER THE OPD NUMBER </td><td> <input type=text name=opdnum>
</td></tr>
<tr><td>
DISCHARGE DATE</td><td><input type=text name=disDate>
</td></tr>
<tr><td>
DISCHARGE TIME</td><td><input type=text name=disTime>
</td></tr>
<tr><td colspan="2">
<input type="submit" value="proceed">
</td></tr>

</table>
<input type="hidden" name="action" value="discharge">
</form>
<a href ="index.jsp">Home</a>
</body>

</html>