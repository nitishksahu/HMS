function checkdraftPayment(){
	var valid=true;
	if(document.finalPayment.opd.value==""||document.finalPayment.opd.value==null)
	{
	alert("opd no should be refill to confirm");
	valid=false;
	}
	if(document.finalPayment.draftNo.value==""||document.finalPayment.draftNo.value==null)
	{
	alert("draft no can not be blank");
	valid=false;
	}
	
	
	if(document.finalPayment.date.value==""||document.finalPayment.date.value==null)
	{
	alert("date field can not be blank");
	valid=false;
	}
	return valid;
}