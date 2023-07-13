package com.primeiroProjetoSpring.myFinanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;
import com.primeiroProjetoSpring.myFinanceApp.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

	public Category insert(Category category) {
		return repository.save(category);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void updateDate(Category categoryOld, Category categoryUpg) {
		categoryOld.setName(categoryUpg.getName());
	}

	public Category updatecategory(Long id, Category category) {
		Category categoryOld = repository.getReferenceById(id);
		updateDate(categoryOld, category);
		return repository.save(categoryOld);
	}

}
