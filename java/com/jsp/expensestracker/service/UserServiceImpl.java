package com.jsp.expensestracker.service;

	import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.jsp.expencestracker.dao.UserDaoImpl;
	import com.jsp.expencestracker.entity.User;
	import com.jsp.expencestracker.dao.*;

	public class UserServiceImpl implements UserService {
		private UserDao userdao= new UserDaoImpl();//upcasting
		@Override
		public int register(User user, String cpassword) {
		if(user.getPassword().equals(cpassword))
		{
			try {
			int userId=	userdao.register(user);
			System.out.println("Service layer userId "+userId);
			return userId;
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	   return 0;
		}
		public User login(String username, String password) {
			try {
				return userdao.login(username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public String forgotpassword(String email) {
			// TODO Auto-generated method stub
			
			try {
				return userdao.forgotpassword(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public User findUserById(int id) {
			try {
				return userdao.findUserById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public int updateProfile(User user, InputStream is) {
			try {
				return userdao.updateUserProfile(user, is);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		@Override
		public byte[] getUserProfileImage(int userId) {
			try {
				return userdao.getUserProfileImage(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


	}

