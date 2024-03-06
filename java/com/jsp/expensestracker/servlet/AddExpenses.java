package com.jsp.expensestracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.jsp.expensestracker.servlet.*;
@WebServlet("/AddExpenses")
public class AddExpenses extends HttpServlet {
	
	private ExpensesService expenseservice=new ExpensesServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch data from html form
		
		Expenses expenses=new Expenses();
		expenses.setAmount(Double.parseDouble(request.getParameter("amount")));
		expenses.setCategory(request.getParameter("category"));
		expenses.setDescription(request.getParameter("description"));
		expenses.setDate(Date.valueOf(request.getParameter("date")));
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userInfo");
		int expenseId=expenseservice.addExpenses(expenses, user.getUserId());
		if(expenseId !=0)
		{
			List<Expenses> list=expenseservice.viewExpenses(user.getUserId());
			request.setAttribute("expensesList", list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewExpenses.jsp");
			dispatcher.include(request, response);
		}
		else
		{
			request.setAttribute("msg", "please enter valid details");
			RequestDispatcher dispatcher=request.getRequestDispatcher("addExpenses.jsp");
			dispatcher.include(request, response);
		}
		//PrintWriter writer=response.getWriter();
		//writer.print("<h1>Expense added successfully,expenseId="+expenseId+"</h1>");
		
	}


}
