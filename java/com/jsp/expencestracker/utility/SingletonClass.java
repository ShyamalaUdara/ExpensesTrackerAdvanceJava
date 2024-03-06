package com.jsp.expencestracker.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonClass {

	private static SingletonClass sc;
	private Connection connect;
	private SingletonClass()
	{
		
	}
	
	public static SingletonClass getSingletonClassObject()
	{
		if(sc==null)
		{
			//create object of singletonClass
			sc=new SingletonClass();
			return sc;
		}
		return sc;
	}
	public Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/expensestracker?user=root&password=12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			connect=DriverManager.getConnection(url);
			System.out.println("Connection Established...");
			return connect;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
