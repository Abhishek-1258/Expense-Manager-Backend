package com.example.cnExpense.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private double amount;
	
	@Column
	private LocalDate date;
	
	@Column
	private String description;
	
	@ManyToMany(mappedBy = "incomes")
	@JsonIgnore
	private List<User> users;
	
	@OneToOne
	@JoinColumn(name = "expense_id")
	@JsonManagedReference
	private Expense expense;
	
	@OneToMany(mappedBy = "income",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private List<IncomeType> incomeTypes;
	
	

	public Income(double amount, LocalDate date, String description, List<User> users, Expense expense,
			List<IncomeType> incomeTypes) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.users = users;
		this.expense = expense;
		this.incomeTypes = incomeTypes;
	}
	
	

	public Income() {
		super();
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public List<IncomeType> getIncomeTypes() {
		return incomeTypes;
	}

	public void setIncomeTypes(List<IncomeType> incomeTypes) {
		this.incomeTypes = incomeTypes;
	}

	public int getId() {
		return id;
	}
	
	
}
