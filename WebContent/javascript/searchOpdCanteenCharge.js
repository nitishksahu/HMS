function checkcanteencharge(){
	var valid=true;
	if((document.payment.canteenCharge.value=="")||(document.payment.canteenCharge.value==null))
{
		alert("canteen charge should be filled out");
		valid=false;
		
	
}

	return valid;
}