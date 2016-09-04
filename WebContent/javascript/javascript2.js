
function Validate()
{
       var valid=true;
	   var no=document.f3.opdnum.value;
       if(isNaN(no)||(no==null)||(no==""))
       {
           alert("please enter a valid number");
           valid=false;
         
       }
       return valid;	
}

