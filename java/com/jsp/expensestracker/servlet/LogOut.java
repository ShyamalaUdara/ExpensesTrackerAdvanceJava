package com.jsp.expensestracker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.access session object
		 * 2.session is null or not 
		 * 3.destory session
		 * 4.perform servlet chaining to display login page
		 */
		HttpSession session=request.getSession();
		if(session!=null)
		{
			session.invalidate();
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			dispatcher.include(request, response);
		}
		}

	

}
