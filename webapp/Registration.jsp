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
ul
{
    list-style-type: none;margin: 0px;
    padding:0px;
    display:flex;
    flex-direction: row;
    background-color: violet;
    height:50px;
    font-weight: bold;
    font-size: 3vh;
    font-family:sans-serif;
}
li a{
    color:black;
    text-decoration: none;
    position:relative;
    top:15px;
    left:30px;
}
#R2
{
position:relative;
left:30px;
height:50px;

}
form
{
    height:450px;
    width:940px;
    background-color:rgb(86, 58, 243);
    margin-left: 250px;
    margin-top: 40px;
}
#R3
{
    font-weight: bolder;
    font-family: sans-serif;
    margin-top: 100px;
}
#R4
{
    height:30px;
    width:860px;
    margin-left: 20px;
    border:1px solid whitesmoke;
    border-radius: 3px;
    font-family: sans-serif;
    padding-left: 20px;
}
#R5
{
    height:35px;
    width:885px;
    color:white;
    font-weight: bold;
    margin-left: 20px;
    border:1px solid black;
    border-radius: 3px;
    font-family: sans-serif;
    padding-left: 20px;
    background-color: skyblue;
}
#R6
{
    color:aqua;
    margin-left: 300px;
}
#R7
{
    color:aqua;
    font-family: sans-serif;
}
   
   </style>
</head>
<body>
    <div id="R1">                                                                      
     <ul>
       <img id="R2" src="./media/logo1.webp">
        <li><a href="" target="_blank" >Spring Expenses Tracker</a></li>
        </div>
    </ul>
    
    <form action="Registration" method="post">
        <br>
        <label id="R3"><center>CREATE ACCOUNT</center></label><br>
        <input id="R4" type="text" placeholder="Your FullName" name="fullname" required><br><br>
        <input id="R4" type="text" placeholder="Your Username" name="username" required><br><br>
        <input id="R4" type="email" placeholder="Your Email" name="email" required><br><br>
        <input id="R4" type="number" placeholder="Your Mobile" name="mobile" required><br><br>
        <input id="R4" type="password" placeholder="Password" name="password" required><br><br>
        <input id="R4" type="password" placeholder="Repeat your password" name="cpassword" required><br><br>
        <button id="R5" value="Sign up"><center>SIGN UP</center></button>
        <p id="R6">Have already an account ? <a id="R7" href="" target="_blank">Login Here</a></p>
    </form>
</body>
</html>