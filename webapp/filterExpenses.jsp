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
    margin-left: 10px;
    margin-top: 5px;
}
#R3
{
    margin-left: 50px;
    margin-top: -35px;
}
ul{
    list-style-type: none;
    margin:0px;
}
#R4
{
    height:40px;
    width:40px;
   position:relative;
   bottom:60px;
   left:700px; 
}
#R5
{
    height:40px;
    width:40px;
    position:relative;
   bottom:100px;
   left:1100px; 
}
form
{
    background-image: radial-gradient(circle,skyblue,white);
    height:350px;
    width:750px;
    border:3px double blueviolet;
    position:relative;
    top:40px;

}
#C3
{
    font-size: 6vh;
    letter-spacing: 7.5px;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;

}
#s1
{
    position:relative;
    top:-20px;
}
#s2
{
    width:650px;
    height:25px;
    border:2px solid white;
    border-radius: 5px;
    text-align: center;
    position:relative;
    top:-5px;

}
#s3
{
    position:relative;
    top:10px;

}
#s4
{
    width:650px;
    height:25px;
    border:2px solid white;
    border-radius: 5px;
    text-align: center;
    position:relative;
    top:20px;
}
#s5
{
    position:relative;
    top:28px;
}
#s6
{
    width:650px;
    height:25px;
    border:2px solid white;
    border-radius: 5px;
    text-align: center;
    position:relative;
    top:35px; 
}
#s7
{
    position:relative;
    top:50px;
    background-color: blue;
    border: 2px solid blue; 
    border-radius: 5px;
    height:25px;
    color:white;
}
#u1
{
position:relative;
left:1300px;
color:white;
bottom:40px;

}
#l1
{
text-decaration:none;
color:black;
}
    </style>
</head>
<body>
<%
		User user = (User)session.getAttribute("userInfo");
	%>
    <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        <li><a href="./Home.jsp"><img src="./media/home2.png" id="R4"></a></li>
       <li>
       <img src="./media/userexpenses1.png" id="R5" onclick=change()>
        <ul id="u1">
        <li>Update Profile</li>
        <li>About Us</li>
        <li>Contact Us</li>
        <li><a href="Login.jsp" id="l1">Logout</a></li>
        </ul>
        </li>
        </div>
    </ul>
    <center>
    <div id="C1">
        <form>
        
        <h1 id="C3">Filter Expense</h1><br>
        <label id="s1">Select Date</label><br>
        <input type="date" id="s2"><br>
        <label id="s3">Select Category</label><br>
        <input type="text" id="s4"><br>
        <label id="s5">Select Amount</label><br>
        <input type="text" id="s6"><br>
        <button id="s7">Submit</button>
    
</form>
    </div>
</center>
<script>
      function change()
      {
    	  const text=document.getElementById('u1');
    	  text.style.position='relative';
    	  text.style.bottom='90px';
    	  text.style.left='1050px';
    	  text.style.color='black';
    	  
       }
    </script>
</body>
</html>
