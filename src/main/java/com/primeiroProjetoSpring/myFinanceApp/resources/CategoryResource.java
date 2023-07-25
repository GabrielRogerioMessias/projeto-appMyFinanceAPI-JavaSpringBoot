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

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;
import com.primeiroProjetoSpring.myFinanceApp.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = service.findById(id);
		return ResponseEntity.ok().body(cat);
	}

	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category category) {
		Category newCat = service.insert(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category).toUri();
		return ResponseEntity.created(uri).body(newCat);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category categoryUpda) {
		Category categ = service.updatecategory(id, categoryUpda);
		return ResponseEntity.ok().body(categ);
	}

<<<<<<< HEAD
	@GetMapping(value = "/findparts/{name}")
=======
	@GetMapping(value = "/findByPart/{name}")
>>>>>>> 6dee269ddbe782636e12df8529d4fdb42ddaa698
	public ResponseEntity<List<Category>> findParts(@PathVariable String name) {
		List<Category> list = service.findByParts(name);
		return ResponseEntity.ok().body(list);

	}

}
