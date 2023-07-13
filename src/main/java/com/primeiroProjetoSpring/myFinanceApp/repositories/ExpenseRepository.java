package com.primeiroProjetoSpring.myFinanceApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeiroProjetoSpring.myFinanceApp.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{

}
