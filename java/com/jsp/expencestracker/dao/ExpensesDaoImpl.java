package com.jsp.expencestracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;
import com.jsp.expencestracker.utility.SingletonClass;

public class ExpensesDaoImpl implements ExpensesDao{
	private Connection connect=SingletonClass.getSingletonClassObject().getConnection();
	private PreparedStatement pstmt;
	@Override
	public int addExpenses(Expenses expenses, int userId) throws Exception {
		// TODO Auto-generated method stub
		String query="insert into expenses(amount,category,description,date,userId)"+"values(?,?,?,?,?)";
		pstmt=connect.prepareStatement(query);
		pstmt.setDouble(1, expenses.getAmount());
		pstmt.setString(2, expenses.getCategory());
		pstmt.setString(3, expenses.getDescription());
		pstmt.setDate(4, expenses.getDate());
		pstmt.setInt(5, userId);
		
		int status=pstmt.executeUpdate();
		if(status !=0)
		{
			String selectQuery="select last_Insert_Id()";
			pstmt=connect.prepareStatement(selectQuery);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				rs.next();
				int expenseId=rs.getInt(1);
                 return expenseId;
			}
			
		}
		
		
		return 0;
	}
	@Override
	public List<Expenses> viewExpenses(int userId) throws Exception {
		String query="select * from expenses where userId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setInt(1,userId);
		ResultSet rs=pstmt.executeQuery();
		List<Expenses> expensesList=new ArrayList<Expenses>();
		if(rs.isBeforeFirst())
		{
			while(rs.next())
			{
				Expenses expenses=new Expenses();
				expenses.setAmount(rs.getDouble("amount"));
				expenses.setDescription(rs.getString("description"));
				expenses.setDate(rs.getDate("date"));
				expenses.setCategory(rs.getString("category"));
				expenses.setExpensesId(rs.getInt("expensesId"));
				expensesList.add(expenses);
			}
				return expensesList;
		}
		return null;
	}
	@Override
	public int deleteExpenseById(int expensesId) throws Exception {
		String query="delete from expenses where expensesId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setInt(1, expensesId);
		int status=pstmt.executeUpdate();
		return status;
	}
	@Override
	public Expenses findExpenseById(int expenseId) throws Exception {
		String query="select * from expenses where expensesId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setInt(1, expenseId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.isBeforeFirst())
		{
			rs.next();
			Expenses expenses=new Expenses();
			expenses.setAmount(rs.getDouble("amount"));
			expenses.setDescription(rs.getString("description"));
			expenses.setDate(rs.getDate("date"));
			expenses.setCategory(rs.getString("category"));
			expenses.setExpensesId(rs.getInt("expensesId"));
			return expenses;
		}
		return null;
	}
	@Override
	public int updateExpenses(Expenses expenses, int expensesId) throws Exception {
		String query="update expenses set amount=?,description=?,date=?,category=?"+
                      "where expensesId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setDouble(1, expenses.getAmount());
		pstmt.setString(2, expenses.getDescription());
		pstmt.setDate(3, expenses.getDate());
		pstmt.setString(4, expenses.getCategory());
		pstmt.setInt(5, expensesId);
		int status = pstmt.executeUpdate();
		return status;
	}
	@Override
	public List<Expenses> totalExpenseList(int userId, Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		String query="select * from expenses where date between ? and ?" + "and userId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setDate(1,start);
		pstmt.setDate(2, end);
		pstmt.setInt(3, userId);
		ResultSet rs=pstmt.executeQuery();
		List<Expenses> expenseList=new ArrayList<Expenses>();
		if(rs.isBeforeFirst())
		{
			while(rs.next())
			{
				Expenses expense=new Expenses();
				expense.setAmount(rs.getDouble("amount"));
				expense.setCategory(rs.getString("category"));
				expense.setDate(rs.getDate("date"));
				expense.setDescription(rs.getString("description"));
				expense.setExpensesId(rs.getInt("expenseId"));
				expenseList.add(expense);
				return expenseList;
			}
		}
		return null;
	}
	
}
	
