package com.example.cnExpense.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.IncomeDAL;
import com.example.cnExpense.entities.Income;

@Service
public class IncomeService {
	
	@Autowired
	IncomeDAL incomeDAL;

	@Transactional
	public Income getById(int incomeid) {
		return incomeDAL.getById(incomeid);
	}

	@Transactional
	public Income save(Integer id,Income income) {
		return incomeDAL.save(id,income);	
	}

}
