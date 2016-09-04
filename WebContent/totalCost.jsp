<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Cost</title>
<style type="text/css">
<%@ include file="css/style.css" %>
</style>

</head>
<body id="body">
<script type="text/javascript" src="javascript/validatetotalcost.js"></script>
<%Object ofee=request.getAttribute("costPayable");
String sfee = ofee.toString(); 
double totalFee = Double.valueOf(sfee).doubleValue();
System.out.println("TOTAL AMOUNT TO BE PAID AFTER INCLUDING CANTEEN CHARGE IS:"+totalFee);
Object oopd=request.getAttribute("opd");
String sopd = oopd.toString(); 
int opd = Integer.parseInt(sopd);


%>
<form name="payment" action="/HMS3/Controller"  method="post" onSubmit="return checkPayment()">
	<table id="mytable" class="styleTable" align="center">
	<tr>
	<th colspan="2"><h1> PAYMENT MODE SELECTION</h1></th>
	</tr>
		
	<tr>
	<th>PAYMENT ON GOING FOR OPD NUMBER</th>
	<th><h2><input type="text"  name="opd" value="<%=opd %>" onFocus="this.blur()" ></h2></input></th>
	</tr>
	
		<tr>
		<td><h5>TOTAL AMOUNT TO BE PAID AFTER INCLUDING CANTEEN CHARGE IS :</h5></td>
		<th><%=totalFee%></th>
		</tr>
		
		<tr>
		<td><input type="hidden" name="costPayable" value="<%=totalFee%>" onFocus="this.blur()"></td>
		</tr>
		
		<tr>
		<td>Please select payment mode</td>
		<td><select name="mode">
		<option value="">--select--</option>
		<option value="cash">Cash</option>
		<option value="draft">Draft</option>
		<option value="card">Credit/Debit Card</option>
		</select>
		</td>
		</tr>
		
		<tr>
		<td><input type="hidden" name="action" value="payMode" ></td>
		</tr>
		
		<tr>
		<td colspan="2" align="center"><input type="submit" value="Proceed To Pay"></td>
		</tr>
		
		
		
	</table>
	</form>
<a href ="index.jsp">Home</a>
<a href ="index.jsp"></a>
</body>

</html>