package com.example.cnExpense.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.ExpenseDAL;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseDAL expenseDAL;

	@Transactional
	public Income save(Integer incomeId, Expense expense) {
		return expenseDAL.save(incomeId, expense);
	}

}
