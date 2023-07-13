package com.primeiroProjetoSpring.myFinanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;
import com.primeiroProjetoSpring.myFinanceApp.repositories.CategoryRepository;
import com.primeiroProjetoSpring.myFinanceApp.services.exceptions.DatabaseException;
import com.primeiroProjetoSpring.myFinanceApp.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category insert(Category category) {
		return repository.save(category);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
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
