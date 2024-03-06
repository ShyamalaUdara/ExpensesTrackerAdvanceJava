<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin page</title>
    <style>
    #R1
{
    background-color:violet;
    height:50px;
    font-weight: bold;
    font-size: 3vh;
    font-family:sans-serif;
}

form{
    background-color: white;
    height:400px;
    width:400px;
    border:3px solid whitesmoke;
    margin-left:450px;
    margin-top: 20px;
    border-radius: 5px;
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
#R4
{
    height:30px;
    width:100px;
    margin-left: 80px;
    border-radius: 5px;
    border:1px solid midnightblue;
    background-color: midnightblue;
}
#R5
{
height:15px;
width:15px;
margin-left: -100px;
margin-bottom:-2px;
   
}
#R6
{
    margin-top: 20px;
    font-size: 3vh;
    font-weight: bolder;
    font-family: sans-serif;

}
#R7
{
    color:white;
   font-size: 2vh;
   margin-left: 25px;
   
   
}
#R8
{
  margin-left:100px ; 
  height:30px; 
  width:120px;
  border-radius: 5px;
    border:1px solid whitesmoke;
    background-color: whitesmoke;
}
#R9
{
    height:20px;
    width:30px;
    position:relative;
    top:5px;
    right:120px;
}
#R10
{
    color:black;
}
#R11
{
    font-weight: bolder;
    margin-top: 30px;
    margin-left: 80px;
   
}
#R12
{
margin-top: 10px;
border:1px solid rgb(225, 213, 213);
height:30px;
margin-left: 80px;
width:245px;
background-color: whitesmoke;
border-radius: 5px;
}
#R13
{
    font-weight: bolder;
    margin-left: 80px;
}
#R14
{
    margin-top: 20px;
    border:1px solid rgb(225, 213, 213);
    height:30px;
    margin-left: 80px;
    width:245px;
    background-color: whitesmoke; 
    border-radius: 5px;
}
#R15
{
    margin-top: 30px;
    border:1px solid rgb(225, 213, 213);
    height:32px;
    margin-left: 80px;
    width:257px;
    background-color: black;
    color:white;  
    border-radius: 5px;
}
#R16
{
    font-size: 2.5vh;
    margin-left: 130px;
    margin-top: 30px;
}
body
{
    background-image: linear-gradient(rgb(195, 183, 183) 50%,violet 90%);
}
ul{
    list-style-type: none;
    margin:0px;
}


    </style>
</head>
<body>
<%
   //to reterieve data-transferred from servlet class
   String message=(String)request.getAttribute("msg"); //downcasting
   if(message!=null)
   {
	   %>
	   <script>
	   alert("<%= message%>");
	   </script>
	   <%
   }
   message=null;
   //reset from---assignment
   
%>
    <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        </div>
    </ul>
        <form id="C1" action="Login" method="post" >

            <label><center id="R6">Sign In With</center></label><br>
            <button id="R4" value="facebook"><a  id="R7" href="https://www.facebook.com/login/" target="_blank"> Facebook</a></button>
                <img id="R5" src="./media/facebook.png">
              <button id="R8" value="google"><a id="R10" href="https://accounts.google.co.in/" target="_blank">Google</a></button>
              <img id="R9" src="./media/google.webp"><br><br>
              <label id="R11">Username</label><br>
              <input id="R12" type="text" name="username"><br><br>
              <label id="R13">Password</label><br>
              <input id="R14" type="password" name="password"><br>
              <button id="R15" value="sign in">Sign In</button>
              <p id="R16">Not have an account?<a href="" target="_blank">Sign Up</a></p>

        </form>
</body>
</html>
