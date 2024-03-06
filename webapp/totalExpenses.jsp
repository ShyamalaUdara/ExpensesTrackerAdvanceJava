<%@page import="com.jsp.expencestracker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #R1
        {
    background-color:violet;
    height:50px;
    font-weight: bold;
    font-size: 3vh;
    font-family:sans-serif;
}
#R2
{
    height:40px;
    width:40px;
    margin-left:10px;
    margin-top:5px;
}
ul{
    list-style-type: none;
    margin:0px;
}
#R3
{
    margin-left:50px;
    margin-top: -35px;
}
#R4{
    margin-left: 700px;
    height: 35px;
    width: 35px;
    position: relative;
    bottom: 58px;

}
#R5{
    font-size:5vh;
    font-weight: bold;
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
#R6{
    font-size:18px;
    font-weight: lighter;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}
#R7{
    position: relative;
    top:45px;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}
#d1{
    width:750px;
    height:45px;
    text-align:center;
    border:2px solid white;
    border-radius:5px;
    background-color:white;
}
#d2{
    width:750px;
    height:45px;
    text-align:center;
    border:2px solid white;
    border-radius:5px;
    background-color:white;
    position: relative;
    top:50px;
}
button{
    position:relative;
    top:90px;
    left:350px;
    width:60px;
    height:30px;
    border:1px white;
    border-radius: 10px;
    background-color: blue;
    color:white;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}
form{
    height:380px;
    width:750px;
    border:3px double blueviolet;
    margin-left:250px;
    margin-top:55px;
    border-radius: 5px;
    padding: 30px;
}
#s1
{
height:650px;
width:1400px;
    background-image:linear-gradient(rgb(43, 234, 43) 50% ,white 60%, mediumpurple 90% );
   
}

</style>
</head>

<body>
<%
		User user = (User)session.getAttribute("userInfo");
	%>
<div id="s1">
    <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        <li><a href="./Home.jsp"><img id="R4" src="./media/home2.png"></a></li>
        </div>
    </ul>
    <div>
    <form>
    
        <label><center id="R5">Total Expense Counter</center></label><br>
        <label><center id="R6" >Start Date</center></label><br>
        <input id="d1" type="date"placeholder="dd-mm-yyyy" name="startdate">
        
        <label><center id="R7">End Date</center></label><br>
        <input id="d2" type="date"placeholder="dd-mm-yyyy" name="enddate"><br>
        <button>Submit</button>
    </form>
    </div>
    </div>
</body>
</html>
