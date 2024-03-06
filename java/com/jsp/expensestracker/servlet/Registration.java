package com.jsp.expensestracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.expencestracker.entity.User;
import com.jsp.expensestracker.service.UserServiceImpl;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

	
	private UserServiceImpl services=new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch data from html form
		String fullname=request.getParameter("fullname");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		//store data in user object
		
		User user=new User();
		user.setFullname(fullname);
		user.setUsername(username);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(cpassword);
		
		//call register method from UserServlet
		
		int userId=services.register(user,cpassword);
		
		//print output on the browser
		PrintWriter writer=response.getWriter();
		
		response.setContentType("text/html");
		
		if(userId !=0)
		{
			//display login.jsp file
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			// to complete servlet chaining
			dispatcher.include(request, response);
			
			writer.print("<h1 style='color:green;'>Registration successfull!!!</h1>");
			writer.print("<h1 style='color:red;'>Your UserId="+userId+"</h1>");
			
		}
		else
		{
			//display Registration.jsp
			RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");
			dispatcher.include(request, response);
			writer.print("<h1 style='color:blue;'>please enter valid details</h1>");
		}
		
		
			
	}

}
