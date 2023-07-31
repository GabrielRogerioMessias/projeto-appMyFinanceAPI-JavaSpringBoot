package com.primeiroProjetoSpring.myFinanceApp.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.primeiroProjetoSpring.myFinanceApp.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private double balance;
	private LocalDate dateBirth;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, double balance, LocalDate dateBirth) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.dateBirth = dateBirth;
	}

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.balance = user.getBalance();
		this.dateBirth = user.getDateBirth();
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

}
