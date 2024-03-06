package com.jsp.expensestracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensestracker.service.UserServiceImpl;
import com.jsp.expencestracker.entity.User;
import com.jsp.expensestracker.service.*;
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private UserService userservice=new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from login page
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user=userservice.login(username,password);
		 PrintWriter writer=response.getWriter();
		 HttpSession session=request.getSession();
		 if(user != null)
		 {
			 //credentails are valid-show home page
			 
			 session.setAttribute("userInfo", user);
			 request.setAttribute("msg","LOGIN SUCCESSFULL");
			 RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
			 dispatcher.include(request,response);
			// writer.print("login successfull");
		 }
		 else
		 {
			 //credentials are invalid
			 request.setAttribute("msg", "PLEASE ENTER VALID CREDENTAILS...");
			 RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			 dispatcher.include(request, response);
			// writer.print("invalid credentials");
		 }
		
	}

}
