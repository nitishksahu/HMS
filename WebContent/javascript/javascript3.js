function Validate()
{
var opdno=document.f2.opdnum.value;
var roomid=document.f2.roomid.value;
var bedno=document.f2.bedno.value;
var duration=document.f2.duration.value;
var valid=true;
if((opdno==null)||(isNaN(opdno))||(opdno==""))
{
alert("Enter a valid opdno");
valid=false;
}
else 
if((roomid==null)||(isNaN(roomid))||(roomid==""))
{
alert("Enter a valid roomid");
valid=false;
}
else
if((bedno==null)||(isNaN(bedno))||(bedno==""))
{
alert("Enter a valid bed no");
valid=false;
}
else
if((duration==null)||(isNaN(duration))||(duration==""))
{
alert("Enter a valid duration");
valid=false;
}
return valid;
}