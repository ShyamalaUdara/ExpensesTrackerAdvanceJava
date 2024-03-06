<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.expencestracker.entity.*" %>

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
table
{
    border:2px solid rgb(0, 217, 255);
    width:800px;
    height:350px;
}
td
{
    position:relative;
    left:30px;
}
#C1
{
    background-color: blue;
    width:52px;
    height:20px;
    border:2px solid blue;
    border-radius: 5px;
    color:white;
    font-size: 2vh;
    position:relative;
    left:20px;

}
#C2
{
    background-color: red;
    width:49px;
    height:20px;
    border:2px solid red;
    border-radius: 5px;
    color:white;
    font-size: 2vh; 
    position:relative;
    left:28px;
}
#C3
{
    color:red;
    text-decoration: underline;
    text-shadow: 1.5px 1.5px 1px red;
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
        <li ><a href="Login.jsp" id="l1">Logout</a></li>
        </ul>
        </li>
        </div>
    </ul>
    <center>
    <h1 id="C3">Expenses Details</h1>
    <table>
        <tr>
            <th>Sr No</th>
            <th>Date</th>
            <th>Amount</th>
            <th>Category</th>
            <th>Descriptio</th>
            <th>Action</th>
        </tr>
        <%
        List<Expenses>listOfExpenses=(List)request.getAttribute("expensesList");
        if(listOfExpenses!=null)
        {
        	for(Expenses e:listOfExpenses){
        %>
        <tr>
            <td>1</td>
            <td><%= e.getDate() %>k</td>
            <td><%= e.getAmount() %></td>
            <td><%= e.getCategory() %></td>
            <td><%= e.getDescription() %></td>
            <td>
            <a href="UpdateExpenses.jsp?expensesId=<%= e.getExpensesId()%>">
                <button value="Update" id="C1">Update</button>
                </a>
                <a href="DeleteExpense?expensesId=<%= e.getExpensesId()%>"> 
                <button value="Delete" id="C2">Delete</button>
                </a>
            </td>
        </tr>
         <%
        	}
        }
         %>
    </table>
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

