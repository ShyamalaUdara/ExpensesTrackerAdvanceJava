package com.jsp.expensestracker.service;

import java.io.InputStream;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;

public interface UserService {
	int register(User user,String cpassword);
	
	User login(String username,String password);
	
	String forgotpassword(String email);
	
	User findUserById(int id);
	
	int updateProfile(User user,InputStream is);
	
	byte[] getUserProfileImage(int userId);

}
