package com.primeiroProjetoSpring.myFinanceApp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.primeiroProjetoSpring.myFinanceApp.entities.Expense;
import com.primeiroProjetoSpring.myFinanceApp.services.ExpenseService;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseResource {

	@Autowired
	private ExpenseService service;

	@GetMapping
	public ResponseEntity<List<Expense>> findAll() {
		List<Expense> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Expense> findById(@PathVariable Long id) {
		Expense exp = service.findById(id);
		return ResponseEntity.ok().body(exp);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Expense> update(@PathVariable Long id, @RequestBody Expense expenseUpdate) {
		Expense exp = service.updateExpense(id, expenseUpdate);
		return ResponseEntity.ok().body(exp);
	}

	@PostMapping(value = "/{userId}/addExpense")
	public ResponseEntity<Expense> insert(@PathVariable Long userId, @RequestBody Expense expense) {
		Expense newExpense = service.insert(userId, expense);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(expense.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newExpense);
	}
}
