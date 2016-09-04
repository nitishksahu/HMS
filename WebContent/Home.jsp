

<html>
<head>

<title>SEARCH PATIENT </title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>

</head>
<body id="body">
<script type="text/javascript" src="javascript/javascript1.js"></script>

<form name="f" action="/HMS3/Controller" method="post" onsubmit="return Validate()">
<table id="mytable" class="styleTable" align="center">
<tr>
<th colspan="2">SEARCH PATIENT FOR WARD ALLOCATION
</th>
</tr>
<tr>
<td>ENTER THE OPD NUMBER</td>
<td> <input type=text name=opdnum></td>
</tr>
<tr>
<td>
<input type="hidden" name="action" value="view"></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="search"></input></td>
</tr>
</table>
</form>
<a href ="index.jsp">Home</a>
</body>
</html>