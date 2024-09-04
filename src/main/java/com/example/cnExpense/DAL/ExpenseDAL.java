package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

public interface ExpenseDAL {
	
	Income save(Integer incomeId,Expense expense);
}
