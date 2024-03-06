package com.jsp.expencestracker.dao;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;

public interface UserDao {
	int register(User user) throws Exception;
	
	User login(String username,String password) throws Exception;
	String forgotpassword(String email) throws Exception;
	
	User findUserById(int id) throws Exception;
	
	int updateUserProfile(User user,InputStream is) throws Exception;
	byte[] getUserProfileImage(int userId) throws Exception;

}
