function checkopd(){
	var valid=true;
	if(document.searchPatient.opd.value==""||document.searchPatient.opd.value==null)
	{
	alert("opd no can not be blank");
	valid=false;
	}
	if(/[^0-9]/.test(document.searchPatient.opd.value)){
		alert("opd no must be numeric");
		valid=false;
	}
	return valid;
}