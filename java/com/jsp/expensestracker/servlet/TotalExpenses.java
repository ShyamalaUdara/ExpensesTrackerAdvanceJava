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

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;
import com.jsp.expensestracker.service.ExpensesService;
import com.jsp.expensestracker.service.ExpensesServiceImpl;


@WebServlet("/TotalExpenses")
public class TotalExpenses extends HttpServlet {
	
private ExpensesService expenseService=new ExpensesServiceImpl();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Date start = Date.valueOf(request.getParameter("start"));
	Date end = Date.valueOf(request.getParameter("end"));
	
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("userInfo");
	
	List<Expenses> totalExpenseList =expenseService .totalExpenseList(user.getUserId(), start, end);
	
	if(totalExpenseList != null) {
		
		request.setAttribute("list", totalExpenseList);
		request.setAttribute("sum", totalExpenseList .stream()
				.mapToDouble(t -> t.getAmount())
				.sum());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewExpense.jsp");
		dispatcher.include(request, response);
	}
	else {
		request.setAttribute("msg", "NO RECORDS FOUND");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewExpense.jsp");
		dispatcher.include(request, response);
	}
}
}
