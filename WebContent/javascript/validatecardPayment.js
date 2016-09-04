function checkcardPayment(){
	var valid=true;
	if(document.finalPayment.opd.value==""||document.finalPayment.opd.value==null)
	{
	alert("opd no should be refill to confirm");
	valid=false;
	}
	if(document.finalPayment.cardNo.value==""||document.finalPayment.cardNo.value==null)
	{
	alert("card no can not be blank");
	valid=false;
	}
	if(/[^0-9]/.test(document.finalPayment.cardNo.value)){
		alert("card no must be numeric");
		valid=false;
	}
	var x=document.finalPayment.cardNo.value;
	var len=x.length;
	if(len!=12)
	{
	alert("card Number must be of exactly 12 digits");
	return false;
	}
	if(document.finalPayment.date.value==""||document.finalPayment.date.value==null)
	{
	alert("date field can not be blank");
	valid=false;
	}
	return valid;
}