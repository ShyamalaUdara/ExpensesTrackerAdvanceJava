package com.jsp.expensestracker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expencestracker.entity.User;
import com.jsp.expensestracker.service.*;

@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	private ExpensesService service=new ExpensesServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from URL
		String temp=request.getParameter("expensesId");
		int expensesId=Integer.parseInt(temp);
		int status=service.deleteExpense(expensesId);
		if(status!=0)
		{
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("userInfo");
			request.setAttribute("list", service.viewExpenses(user.getUserId()));
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewExpenses.jsp");
			dispatcher.include(request, response);
		}

	}

	
}
