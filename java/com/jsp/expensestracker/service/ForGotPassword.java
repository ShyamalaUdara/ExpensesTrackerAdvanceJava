package com.jsp.expensestracker.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForGotPassword")
public class ForGotPassword extends HttpServlet {
	UserService userservice=new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail=request.getParameter("email");
		userservice.forgotpassword(mail);
		RequestDispatcher dispatcher=request.getRequestDispatcher("forgotpassword.jsp");
		dispatcher.include(request,response);
		
	}

}
