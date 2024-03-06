<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jsp.expensestracker.service.*" %>
    <%@ page import="com.jsp.expencestracker.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
#R5
{
    height:40px;
    width:40px;
    position:relative;
   bottom:55px;
   left:1100px; 
   
}
#u1
{
position:relative;
left:1300px;
color:black;
bottom:40px;

}
#l1
{
text-decaration:none;
color:black;
}
#i1
{
width:100px;
height:20px;
margin-right:80px;
}
form
{
height:500px;
width:500px;
border:3px solid black;
}
label
{
   margin-right:120px;
}
#p1
{
margin-left:20px;
}

</style>
<body>
<% 
    int userId=Integer.parseInt(request.getParameter("userId"));
     UserService userService=new UserServiceImpl();
    User user=userService.findUserById(userId);
     
%>
      <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        <li>
       <img src="./media/userexpenses1.png" id="R5" onclick=change()>
        <ul id="u1">
        <li>Update Profile</li>
        <li>About Us</li>
        <li>Contact Us</li>
        <li ><a href="Login.jsp" id="l1">Logout</a></li>
        </ul>
        </li>
        </div>
    </ul>
    <center>
    <form method="post" enctype="multipart/form-data" action="updateProfile">
    <input value=<%= user.getUserId()%> name="userId" hidden>
    <h1>Update Your Profile</h1>
    <label>Username</label><br><br>
    <input type="text" name="username" value=<%= user.getUsername()%>><br><br>
    <label>Email</label><br><br>
    <input type="email" name="email" value=<%= user.getEmail()%>><br><br>
    <label>Mobile</label><br><br>
    <input type="number" name="number" value=<%= user.getMobile()%>><br><br>
    <label>Password</label><br><br>
    <input type="password" name="password" value=<%= user.getPassword()%>><br><br>
     <label >Profile photo</label><br><br>
     <input type="file" id="fileInput" accept="image/*" name="imageFile">
     <img id="displayImage">
     
     <button>Update Profile</button>
     </form>
     </center>
    <script>
      function change()
      {
    	  const text=document.getElementById('u1');
    	  text.style.position='relative';
    	  text.style.bottom='40px';
    	  text.style.left='1050px';
    	  text.style.color='black';
    	  
       }
      const fileInput=document.getElementById("fileInput");
      const displayImage=document.getElementById("displayImage");
      
      fileInput.addEventListener("change",function()
      {
    	  const file=fileInput.files[0];
    	  if(file && file.type.startsWith("image/"))
    		  {
    		  const reader=new FileReader();
    		  reader.onload=function(e)
    		  {
    			  displayImage.src=e.target.result;
    			  displayImage.style.display="block";
    		  };
    		  reader.readAsDataURL(file);
    		  }
      }
      
    </script>
</body>
</html>