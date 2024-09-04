package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;

public interface IncomeDAL {
	
	Income getById(int id);
	
	Income save(Integer id,Income income);
}
