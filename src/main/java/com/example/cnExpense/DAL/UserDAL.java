package com.example.cnExpense.DAL;

import java.util.List;

import com.example.cnExpense.entities.User;

public interface UserDAL {

	List<User> getAllUsers();
	
	User getById(Integer id);
	
	User save(User user);
	
	boolean checkUserExist(User user);

	User find(User user);

	List<User> filteredUserListByType(String incomeType, String expenseType);
}
