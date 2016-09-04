<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Draft Payment Portal</title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>
</head>
<body id="body">
<script type="text/javascript" src="javascript/validatedraftPayment.js"></script>
<%Object ofee=request.getAttribute("costPayable");
String sfee = ofee.toString(); 
double totalFee = Double.valueOf(sfee).doubleValue();
Object omode=request.getAttribute("mode");
String mode = omode.toString(); 
Object oopd=request.getAttribute("opd");
String sopd = oopd.toString(); 
int opd = Integer.parseInt(sopd);
%>
<form name="finalPayment" action="/HMS3/Controller" method="post"onSubmit="return checkdraftPayment()">
<table id="mytable" class="styleTable" align="center" >

<tr>
<th colspan="2">DRAFT PAYMENT</th>
</tr>

<tr>
<td>OPD CONFIRMATION:</td>
<td><input type="text" name="opd" value=<%=opd %> onFocus="this.blur()"></td>
</tr>

<tr>
<td>Amount to be paid :</td>
<td><input type="text" name="amount" value="<%=totalFee %>" onFocus="this.blur()"> </td>
</tr>

<tr>
<td>The selected mode is:</td>
<td><input type="text" name="mode" value="<%=mode %>" onFocus="this.blur()"></input></td>
</tr>

<tr>
<td>Please Enter Your Draft Number</td>
<td><input type="text" name="draftNo"></input></td>
</tr>
<tr>
<td>Payment Date:</td>
<td><input type="text" name="date" value="DD-MM-YYYY"></input></td>
</tr>

<tr><td colspan="2"><input type="submit" value="Make Payment"></td>

</tr>

<tr>
<td><input type="hidden" name="action" value="finalPay"></td>
</tr>

</table>
</form>
<a href ="index.jsp">Home</a>
</body>
</html>