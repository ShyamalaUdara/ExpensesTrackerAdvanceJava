package com.jsp.expencestracker.dao;

import java.sql.Date;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;
import com.jsp.expencestracker.entity.User;

public interface ExpensesDao {
	
    int addExpenses(Expenses expenses,int userId) throws Exception;
    
    List<Expenses> viewExpenses(int userId) throws Exception;
    int deleteExpenseById(int expenseId) throws Exception;
    
    Expenses findExpenseById(int expenseId) throws Exception;
    int updateExpenses(Expenses expenses,int expensesId) throws Exception;
    List<Expenses> totalExpenseList(int userId,Date start,Date end) throws Exception;
}
