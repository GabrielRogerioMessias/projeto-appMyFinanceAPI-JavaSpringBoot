package com.primeiroProjetoSpring.myFinanceApp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double balance;
	private LocalDate dateBirth;

	@OneToMany(mappedBy = "user")
	private List<Entrance> entrances = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Expense> expenses = new ArrayList<>();

	public User() {
		super();
	}

	public User(Long id, String name, double balance, LocalDate dateBirth) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.dateBirth = dateBirth;
	}

	public void adicionarExpense(Expense expense) {
		double valueExpense = expense.getValueExpense();
		this.balance -= valueExpense;
	}

	public void adicionarEntrance(Entrance entrance) {
		double valueEntrance = entrance.getValueEntrance();
		this.balance += valueEntrance;
	}

	public double getTotExpense() {
		double totalExpense = 0;
		for (Expense x : expenses) {
			totalExpense += x.getValueExpense();
		}
		return totalExpense;
	}

	public double getTotalEntrance() {
		double totalEntrance = 0;
		for (Entrance x : entrances) {
			totalEntrance += x.getValueEntrance();
		}
		return totalEntrance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
