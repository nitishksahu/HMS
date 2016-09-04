function checkPayment(){
	var valid=true;
		
	if(document.payment.mode.value=="")
	{
	alert("you must select the mode of payment to proceed");
	valid=false;
	}
	return valid;
}