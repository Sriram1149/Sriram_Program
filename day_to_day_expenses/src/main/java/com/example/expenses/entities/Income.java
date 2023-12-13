package com.example.expenses.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int amount;
	private String Comments;
	private int incomeId;
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	@Override
	public String toString() {
		return "Income [amount=" + amount + ", Comments=" + Comments + ", incomeId=" + incomeId + "]";
	}
}
