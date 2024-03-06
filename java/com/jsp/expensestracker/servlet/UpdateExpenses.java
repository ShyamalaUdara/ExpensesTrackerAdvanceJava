package com.jsp.expensestracker.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensestracker.service.*;
import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;
import com.jsp.expencestracker.utility.*;
@WebServlet("/UpdateExpenses")
public class UpdateExpenses extends HttpServlet {
	private ExpensesService service=new ExpensesServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch expensesId
		int expensesId=Integer.parseInt(request.getParameter("eId"));
		//fetch expenseId information-amount,date,category,description
		Expenses expense=new Expenses();
	     expense.setAmount(Double.parseDouble(request.getParameter("amount")));
	     expense.setCategory(request.getParameter("category"));
	     expense.setDescription(request.getParameter("description"));
	     expense.setDate(Date.valueOf(request.getParameter("date")));
		//store all expense info in Expense object
	     int status=service.updateExpenses(expense, expensesId);
	   //return 1-then display viewexpenses.jsp
	     if(status!=0)
	     {
	    	 HttpSession session=request.getSession();
	    	 User user=(User)session.getAttribute("userInfo");
	    	 List<Expenses> expensesList=service.viewExpenses(user.getUserId());
	    	 request.setAttribute("expensesList", expensesList);
	    	 RequestDispatcher dispatcher=request.getRequestDispatcher("viewExpenses.jsp");
	    	 dispatcher.include(request, response);
	    	 
	     }
		//return 0-then display updateexpenses.jsp
	     else
	     {
	    	 request.setAttribute("msg", "PLEASE ENTER VALID DETAILS...");
	    	 RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateExpenses.jsp");
	    	 dispatcher.include(request, response);
	     }
		
	}

	

}
