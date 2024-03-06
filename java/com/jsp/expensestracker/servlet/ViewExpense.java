package com.jsp.expensestracker.servlet;
import com.jsp.expensestracker.service.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;


@WebServlet("/ViewExpense")
public class ViewExpense extends HttpServlet {
	
	private ExpensesService expenseService=new ExpensesServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		//Fetch User object from session
	HttpSession session=request.getSession();
	
	User user=(User)session.getAttribute("userInfo");
	
	
	List<Expenses> listOfExpense=expenseService.viewExpenses(user.getUserId());
	
	request.setAttribute("expensesList", listOfExpense);
	RequestDispatcher dispatcher=request.getRequestDispatcher("viewExpenses.jsp");
	dispatcher.include(request, response);
	}

	

}
