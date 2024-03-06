package com.jsp.expencestracker.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;
import com.jsp.expencestracker.utility.SingletonClass;

public class UserDaoImpl implements UserDao{
	//Establish Connection
		private Connection connect=SingletonClass.getSingletonClassObject().getConnection();
		
		//Create Platform
		private PreparedStatement pstmt;
		
		
		@Override
		public int register(User user) throws Exception {
			
			//insert query- to insert data in user table
			String insert="insert into user"
					+"(fullname,username,email,mobile,password)"
							+ "values(?,?,?,?,?)";
			
			pstmt=connect.prepareStatement(insert);
			
			
			//set values for placeholder- take values from user object
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getFullname());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getMobile());
			pstmt.setString(5,user.getPassword());
			
			//execute insert query
			int status=pstmt.executeUpdate();
			System.out.println("Satus of insert query "+status);
			
			if(status!=0)
			{
				//retrieve the userId from database
				String select="select userId from user where email=?";
				
				pstmt=connect.prepareStatement(select);
				
				pstmt.setString(1,user.getEmail());
				ResultSet rs=pstmt.executeQuery();
				if(rs.isBeforeFirst())
				{
					rs.next();
					System.out.println("UserId ="+rs.getInt("userId"));
					return rs.getInt("userId");
				}
			}
			return 0;
		}


		@Override
		public User login(String username, String password) throws Exception {
			String query="select * from user where username=? and password=?";
			pstmt=connect.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs= pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				rs.next();
				
				String un=rs.getString("username");
				String fullname=rs.getString("fullname");
				String email=rs.getString("email");
				String mobile=rs.getString("mobile");
				String pwd=rs.getString("password");
			    int id=rs.getInt("userId");
				
				User user=new User();
				user.setUsername(un);
				user.setFullname(fullname);
				user.setEmail(email);
				user.setMobile(mobile);
				user.setPassword(pwd);
				user.setUserId(id);
				return user;
			}
			return null;
		}


		@Override
		public String forgotpassword(String email) throws Exception {
			// TODO Auto-generated method stub
			
			String query="select password from user where email=?";
			pstmt=connect.prepareStatement(query);
			pstmt.setString(1,email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				rs.next();
				String pwd=rs.getString("password");
				return pwd;
			}
			return null;
		}


		@Override
		public User findUserById(int id) throws Exception {
			// TODO Auto-generated method stub
						String query="select * from user where userId=?";
						pstmt=connect.prepareStatement(query);
						pstmt.setInt(1, id);
						ResultSet rs=pstmt.executeQuery();
						if(rs.isBeforeFirst())
						{
							rs.next();
							User user=new User();
							user.setEmail(rs.getString("email"));
							user.setFullname(rs.getString("fullname"));
							user.setMobile(rs.getString("mobile"));
							user.setPassword(rs.getString("password"));
							user.setUsername(rs.getString("username"));
							user.setUserId(rs.getInt("userId"));
							return user;
						}
						return null;
		}


		@Override
		public int updateUserProfile(User user, InputStream is) throws Exception {
			String query="update user set fullname=?,username=?, mobile=?,email=?,"+
		                 "password=?, image=?, where userId=?";
			pstmt=connect.prepareStatement(query);
			pstmt.setString(1, user.getFullname());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getMobile());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5,user.getPassword());
			pstmt.setBlob(6, is);
			pstmt.setInt(7, user.getUserId());
			
			int status=pstmt.executeUpdate();
			System.out.println("execution completed successfully");
			return status;
			
		}


		@Override
		public byte[] getUserProfileImage(int userId) throws Exception {
			// TODO Auto-generated method stub
			String query="select * from user where userId=?";
			pstmt=connect.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				rs.next();
				Blob blob=rs.getBlob("image");
				if(blob!=null)
				{
					byte byteArray[]=blob.getBytes(1, (int)blob.length());
					return byteArray;
				}
			}
			return null;
		}

			}


