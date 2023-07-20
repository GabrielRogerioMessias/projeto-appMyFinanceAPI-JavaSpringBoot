package com.primeiroProjetoSpring.myFinanceApp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entrance")
public class Entrance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double valueEntrance;
	private LocalDate dateEntrance;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Entrance() {
		super();
	}

	public Entrance(Long id, String description, double valueEntrance, LocalDate dateEntrance) {
		super();
		this.id = id;
		this.description = description;
		this.valueEntrance = valueEntrance;
		this.dateEntrance = dateEntrance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValueEntrance() {
		return valueEntrance;
	}

	public void setValueEntrance(double value) {
		this.valueEntrance = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDateEntrance() {
		return dateEntrance;
	}

	public void setDateEntrance(LocalDate dateEntrance) {
		this.dateEntrance = dateEntrance;
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
		Entrance other = (Entrance) obj;
		return Objects.equals(id, other.id);
	}

}
