package com.example.cnExpense.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.UserDAL;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import java.util.ArrayList;
@Service
public class UserService {

	@Autowired
	UserDAL userDAL;

	@Transactional
	public List<User> getAllUsers() {
		return userDAL.getAllUsers();
	}

	@Transactional
	public User getById(Integer id) {
		return userDAL.getById(id);
	}

	@Transactional
	public User save(User user) {
		return userDAL.save(user);
	}

	@Transactional
	public boolean checkUserExists(User user) {
		return userDAL.checkUserExist(user);
	}

	@Transactional
	public User find(User user) {
		return userDAL.find(user);
	}

	@Transactional
	public List<User> filteredUserListByType(String incomeType, String expenseType) {
		return userDAL.filteredUserListByType(incomeType,expenseType);
	}

	@Transactional
	public List<User> filterByCalender(String day, String month, String year) {
		List<User> users = userDAL.getAllUsers();
		List<User> filteredUsers = new ArrayList<>();
		for(User user : users) {
			List<Income> filteredIncomes = new ArrayList<>();
			for(Income income : user.getIncomes()) {
				if ((income.getDate()!=null) && (day != null && !day.isEmpty() && !(Integer.parseInt(day)==income.getDate().getDayOfMonth()))) {
					continue;
				}
				else if ((income.getDate()!=null) && (month != null && !month.isEmpty() && !(Integer.parseInt(month)==income.getDate().getMonthValue()))) {
					continue;
				}
				else if ((income.getDate()!=null) && (year != null && !year.isEmpty() && !(Integer.parseInt(year)==income.getDate().getYear()))) {
					continue;
				}
				filteredIncomes.add(income);
			}
			user.setIncomes(filteredIncomes);
			filteredUsers.add(user);
		}
		
		return filteredUsers;
		
		
	}

}
