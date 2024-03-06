package com.jsp.expencestracker.entity;

import java.sql.Date;

public class Expenses {
	//to represent columns of expense table
		private double amount;
		private String category;
		private String description;
		private Date date;
		private int expensesId;
		
		public Expenses() {
			super();
			
		}
       public Expenses(double amount, String category, String description, Date date, int expensesId) {
			super();
			this.amount = amount;
			this.category = category;
			this.description = description;
			this.date = date;
			this.expensesId = expensesId;
		}

     public int getExpensesId() {
		return expensesId;
	}
	public void setExpensesId(int expensesId) {
		this.expensesId = expensesId;
	}
		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		@Override
		public String toString() {
			return "Expenses [amount=" + amount + ", category=" + category + ", description=" + description + ", date="
					+ date + ", expensesId=" + expensesId + "]";
		}
		
}
