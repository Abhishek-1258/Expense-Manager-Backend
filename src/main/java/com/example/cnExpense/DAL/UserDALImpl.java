package com.example.cnExpense.DAL;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.ExpenseType;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.IncomeType;
import com.example.cnExpense.entities.User;

@Repository
public class UserDALImpl implements UserDAL {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<User> getAllUsers() {
		Session session = entityManager.unwrap(Session.class);
		List<User> users = session.createQuery("Select u From User u",User.class).getResultList();
		return users;
	}

	@Override
	public User getById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(User.class, id);
	}

	@Override
	public User save(User user) {
		Session session = entityManager.unwrap(Session.class);
		Integer id = (Integer)session.save(user);
		return getById(id);
	}

	@Override
	public boolean checkUserExist(User newUser) {
		List<User> users = getAllUsers();
		for(User user : users) {
			if(user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User find(User newUser) {
		List<User> users = getAllUsers();
		for(User user : users) {
			if(user.getUsername().equals(newUser.getUsername())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> filteredUserListByType(String incomeType, String expenseType) {
		List<User> userList = getAllUsers();
        List<User> filteredList = new ArrayList<>();
        for (User user : userList) {
            List<Income> filteredIncomes = new ArrayList<>();
            for (Income income : user.getIncomes()) {
                if (incomeType != null && !incomeType.isEmpty()) {
                    boolean foundIncomeType = false;
                    for (IncomeType type : income.getIncomeTypes()) {
                        if (type.getName().equalsIgnoreCase(incomeType)) {
                            foundIncomeType = true;
                            break;
                        }
                    }
                    if (!foundIncomeType) {
                        continue;
                    }
                }
                else if (expenseType != null && !expenseType.isEmpty()) {
                    boolean foundExpenseType = false;
                    for (ExpenseType type : income.getExpense().getExpenseTypes()) {
                        if (type.getName().equalsIgnoreCase(expenseType)) {
                            foundExpenseType = true;
                            break;
                        }
                    }
                    if (!foundExpenseType) {
                        continue;
                    }
                }
                filteredIncomes.add(income);
            }
            user.setIncomes(filteredIncomes);
            filteredList.add(user);
        }
        return filteredList;
	} 

}
