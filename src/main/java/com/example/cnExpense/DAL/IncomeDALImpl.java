package com.example.cnExpense.DAL;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

@Repository
public class IncomeDALImpl implements IncomeDAL {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	UserDAL userDAL;

	@Override
	public Income getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Income.class, id);
	}

	@Override
	public Income save(Integer id,Income income) {
		Session session = entityManager.unwrap(Session.class);
		Integer incomeId = (Integer)session.save(income);
		User user = userDAL.getById(id);
		Income savedIncome = getById(incomeId);
		if(user != null) {
			user.getIncomes().add(savedIncome);
			userDAL.save(user);
		}
		return getById(incomeId);
 	}

}
