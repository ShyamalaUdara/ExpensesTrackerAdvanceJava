package com.jsp.expensestracker.service;

import java.sql.Date;
import java.util.List;

import com.jsp.expencestracker.entity.Expenses;

public interface ExpensesService  {
	int addExpenses(Expenses expenses, int userId);
	List<Expenses> viewExpenses(int userId);
	int deleteExpense(int expensesId);
	Expenses findExpenseById(int expenseId);
	int updateExpenses(Expenses expenses, int expensesId);
    List<Expenses> totalExpenseList(int userId, Date start, Date end);
	
	List<Expenses> filterExpenseByCategory(String category, int userId);
	
	List<Expenses> filterExpenseByAmountRange(int start, int end, int userId);
}