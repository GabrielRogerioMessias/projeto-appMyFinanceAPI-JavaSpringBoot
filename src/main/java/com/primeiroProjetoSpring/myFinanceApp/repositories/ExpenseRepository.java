package com.primeiroProjetoSpring.myFinanceApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.primeiroProjetoSpring.myFinanceApp.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	@Query("SELECT expen FROM Expense expen WHERE expen.description LIKE %:description%")
	public List<Expense> findByParts(@Param("description") String description);
}
