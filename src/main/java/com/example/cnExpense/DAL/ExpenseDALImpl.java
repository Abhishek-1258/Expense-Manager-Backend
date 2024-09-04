package com.example.cnExpense.DAL;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

@Repository
public class ExpenseDALImpl implements ExpenseDAL{
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	IncomeDAL incomeDAL;

	@Override
	public Income save(Integer incomeId, Expense expense) {
		Session session = entityManager.unwrap(Session.class);
		Integer expenseId = (Integer)session.save(expense);
		Income income = incomeDAL.getById(incomeId);
		Expense savedExpense = session.get(Expense.class, expenseId);
		if(income != null) {
			income.setExpense(savedExpense);
			session.save(savedExpense);
		}
		return income;
	}
	
	
}
