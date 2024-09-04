package com.example.cnExpense.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String nickname;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Expense> expenses;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_income",
	joinColumns = {@JoinColumn(name = "user_id")},
	inverseJoinColumns = {@JoinColumn(name = "income_id")})
	private List<Income> incomes = new ArrayList<>();

	
	public User() {
		super();
	}

	public User(String username, String nickname, String email, String address, List<Expense> expenses,
			List<Income> incomes) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.address = address;
		this.expenses = expenses;
		this.incomes = incomes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Integer getId() {
		return id;
	}
	
	
}
