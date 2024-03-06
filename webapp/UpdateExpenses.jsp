<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jsp.expensestracker.service.*" %>
<%@ page import="com.jsp.expencestracker.entity.*" %>
<%@page import="com.jsp.expencestracker.entity.User"%>
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
body
{
    background-image: linear-gradient(rgb(168, 41, 41) 50% ,rgb(165, 49, 49) 90%);
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
#R7
{
  background-color: rgb(218, 57, 159);
  height:420px;
  width:700px;
  position:relative;
  top:30px;
  left:350px;

}
#R6
{
    height:200px;
    width:200px;
    position:relative;
    top:100px;
    left:100px;
}
#R8
{
    position:relative;
    left:400px;
    bottom:200px;
}
#R9
{
    font-size: 3vh;
}
#R10
{
    background-color: aliceblue;
    border:2px solid aliceblue;
    width:200px;
    height:25px;
    border-radius: 12px;
    font-size: 2.5vh;
    padding-left: 15px;
}
#R13
{
    background-color: aliceblue;
    border:2px solid aliceblue;
    width:200px;
    height:28px;
    border-radius: 12px;
    font-size: 2.5vh;
    padding-left: 15px;
}
#R11
{
    background-color: aliceblue;
    border:2px solid aliceblue;
    width:200px;
    height:28px;
    border-radius: 12px;
    font-size: 2.5vh;
    padding-left: 15px;
}
#R12
{
    background-color: aliceblue;
    border:2px solid aliceblue;
    width:200px;
    height:85px;
    border-radius: 12px;
    font-size: 2.5vh;
    padding-left: 15px;
}
#R15
{
    background-color:green;
    height:30px;
    width:120px;
    position:relative;
    left:50px;
    border:2px solid green;
    border-radius: 10px;


}
    </style>
</head>
<body>
<% 
    int eId=Integer.parseInt(request.getParameter("expensesId"));
     ExpensesService expenseService=new ExpensesServiceImpl();
    Expenses expenses=expenseService.findExpenseById(eId);
    User user = (User)session.getAttribute("userInfo");
    
     
%>
 
    <div id="R1">
        <ul>
       <li><img id="R2" src="./media/logo1.webp"></li> 
        <li><h3 id="R3">Spring Expenses Tracker</h3></li>
        <li><a href="./Home.jsp"><img src="./media/home2.png" id="R4"></a></li>
       <li><a href="Login.jsp"><img src="./media/userexpenses1.png" id="R5"> </a>
        </li>
        </div>
    </ul>
    <form action="UpdateExpenses?expensesId=<%= expenses.getExpensesId()%>">
    <div id="R7">
        <img src="./media/addExpense (2).png" id="R6">
        <div id="R8">
        <input value=<%= expenses.getExpensesId()%> name="eId" hidden>
            <h2 id="R9">Update Expenses</h2>
            <input type="number" placeholder="Amount" id="R10" name="amount" value=<%= expenses.getAmount()%>><br><br>
            <input type="date" id="R13" name="date" value=<%= expenses.getDate() %>><br><br>
            <input list="category" placeholder="category" id="R11" name="category" value=<%= expenses.getCategory() %>>
            <datalist id="category">
                <option value="Utilities">Utilities</option>
                <option value="Transportation">Transportation</option>
                <option value="Groceries">Groceries</option>
                <option value="DiningOut">DiningOut</option>
                <option value="Entertainment">Entertainment</option>
                <option value="HealthCare">HealthCare</option>
                <option value="Education">Education</option>
                <option value="PersonalCare">PersonalCare</option>
                <option value="Clothing">Clothing</option>
                <option value="HomeMaintainance">HomeMaintainance</option>
                <option value="Gifts&Donations">Gifts&Donations</option>
                <option value="Saving&investments">Saving&investments</option>
                <option value="Tax">Tax</option>
                <option value="Others">Others</option>
            </datalist><br><br>
            <textarea id="R12" name="description" placeholder="description"><%= expenses.getDescription() %></textarea><br><br>
            <button value="UPDATE +" id="R15">UPDATE +</button>
        </div>
    </div>
    </form>
    
</body>
</html>
