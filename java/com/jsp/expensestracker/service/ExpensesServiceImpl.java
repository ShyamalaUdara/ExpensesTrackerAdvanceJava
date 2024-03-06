package com.jsp.expensestracker.service;

import com.jsp.expencestracker.entity.Expenses;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jsp.expencestracker.dao.*;
public class ExpensesServiceImpl implements ExpensesService{

	private ExpensesDao expensesdao=new ExpensesDaoImpl();
	@Override
	public int addExpenses(Expenses expenses, int userId) {
		// TODO Auto-generated method stub
		try {
			return expensesdao.addExpenses(expenses, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public List<Expenses> viewExpenses(int userId) {
		// TODO Auto-generated method stub
		try {
			return expensesdao.viewExpenses(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteExpense(int expensesId) {
		try {
			return expensesdao.deleteExpenseById(expensesId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Expenses findExpenseById(int expenseId) {
		try {
			return expensesdao.findExpenseById(expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateExpenses(Expenses expenses, int expensesId) {
		try {
			return expensesdao.updateExpenses(expenses, expensesId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Expenses> totalExpenseList(int userId, Date start, Date end) {
		// TODO Auto-generated method stub
		try {
			return expensesdao.totalExpenseList(userId, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Expenses> filterExpenseByCategory(String category, int userId) {
		// TODO Auto-generated method stub
		try {
			return expensesdao.viewExpenses(userId).stream().filter(t -> t.getCategory().equals(category))
					.collect(Collectors.toList());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Expenses> filterExpenseByAmountRange(int start, int end, int userId) {
		// TODO Auto-generated method stub
		try {
			return expensesdao.viewExpenses(userId).stream().filter(t -> t.getAmount() >= start && t.getAmount() <= end)
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
