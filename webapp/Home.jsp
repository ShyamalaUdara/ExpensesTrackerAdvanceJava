<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jsp.expencestracker.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
body
{
    background-image:linear-gradient(to right,rgb(215, 4, 215),black,black)
}
ul{
    list-style-type: none;
    margin:0px;
}
#R5
{
    height:40px;
    width:40px;
    position:relative;
   bottom:55px;
   left:1100px; 
   
}
#C1
{
    color:white;
    text-decoration: none;
    font-size: 5vh;
    position:relative;
    top:150px;
    left:300px;
}
#C2
{
    color:white;
    text-decoration: none;
    font-size: 5vh;
    position:relative;
    top:150px;
    left:580px;
}
#C3
{
    color:white;
    text-decoration: none;
    font-size: 5vh;
    position:relative;
    top:380px;
    right:100px;
}
#C4
{
    color:white;
    text-decoration: none;
    font-size: 5vh;
    position:relative;
    top:380px;
    left:170px;
}
#button
{
position:relative;
top:200px;
left:600px;
}
#i1
{
position:relative;
bottom:200px;
right:260px;
}
#i2
{
position:relative;
bottom:5px;
right:360px;
height:80px;

}
#i3
{
position:relative;
bottom:220px;
width:90px;
}
#i4
{
position:relative;
top:10px;
right:90px;
width:120px;
}
#b5
{
position:relative;
left:550px;
top:60px;
color:red;}
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
color:white;
}
    </style>
</head>
<body>
<%
    String message=(String)request.getAttribute("msg");
   User user=(User)session.getAttribute("userInfo");

if(message !=null)
{
%>
<script>
alert("<%= message%>");
</script>
<%
  message=null;
}
%>
    <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        <li>
       <img src="./media/userexpenses1.png" id="R5" onclick=change()>
        <ul id="u1">
        <li><a href="./UpdateProfile.jsp?userId=<%= user.getUserId()%>" id="l1">Update Profile</a></li>
        <li>About Us</li>
        <li>Contact Us</li>
        <li ><a href="Login.jsp" id="l1">Logout</a></li>
        </ul>
        </li>
        </div>
    </ul>
    <a href="./addExpenses.jsp" id="C1" target="_blank">Add Expenses</a>
    <a href="ViewExpense" id="C2" target="_blank">View Expenses</a>
    <a href="./totalExpenses.jsp" id="C3" target="_blank">Total Expenses</a>
    <a href="./filterExpenses.jsp" id="C4" target="_blank">Filter Expenses</a>
   <div id="button">
    <img src="./media/dollar56 (2).jpg" id="i1">
    <img src="./media/summation.jpg" id="i2">
    <img src="./media/eye45 (2).jpg" id="i3">
    <img src="./media/filter123.webp" id="i4">
    </div>
    <div id="b5">
    <%
      if(user!=null)
      {
    	  %>
    	  <h1 id="wel">Welcome<%= user.getFullname()%></h1>
    	  <% 
      }
    %>
    </div>
    <script>
      function change()
      {
    	  const text=document.getElementById('u1');
    	  text.style.position='relative';
    	  text.style.bottom='40px';
    	  text.style.left='1050px';
    	  text.style.color='white';
    	  
       }
    </script>
</body>
</html>
