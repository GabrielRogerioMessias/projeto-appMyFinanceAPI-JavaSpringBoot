package com.primeiroProjetoSpring.myFinanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;
import com.primeiroProjetoSpring.myFinanceApp.entities.Expense;
import com.primeiroProjetoSpring.myFinanceApp.entities.User;
import com.primeiroProjetoSpring.myFinanceApp.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository repository;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;

	public List<Expense> findAll() {
		return repository.findAll();
	}

	public Expense findById(Long id) {
		Optional<Expense> obj = repository.findById(id);
		return obj.get();
	}

	public Expense insert(Long id, Expense expense) {
		User user = userService.findById(id);
		Long categoryId = expense.getCategory().getId();
		Category category = categoryService.findById(categoryId);
		expense.setUser(user);
		user.adicionarExpense(expense);
		expense.setCategory(category);
		category.addExpense(expense);
		return repository.save(expense);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void updateDate(Expense expenseOld, Expense expenseUpg) {
		expenseOld.setValueExpense(expenseUpg.getValueExpense());
		expenseOld.setDescription(expenseUpg.getDescription());
		expenseOld.setCategory(expenseUpg.getCategory());
	}

	public Expense updateExpense(Long id, Expense expense) {
		Expense expenseOld = repository.getReferenceById(id);
		updateDate(expenseOld, expense);
		return repository.save(expenseOld);
	}

}
