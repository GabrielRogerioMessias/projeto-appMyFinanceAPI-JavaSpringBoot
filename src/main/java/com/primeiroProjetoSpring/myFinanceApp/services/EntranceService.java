package com.primeiroProjetoSpring.myFinanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;
import com.primeiroProjetoSpring.myFinanceApp.entities.Entrance;
import com.primeiroProjetoSpring.myFinanceApp.entities.User;
import com.primeiroProjetoSpring.myFinanceApp.repositories.EntranceRepository;
import com.primeiroProjetoSpring.myFinanceApp.services.exceptions.ResourceNotFoundException;

@Service
public class EntranceService {
	@Autowired
	private EntranceRepository repository;

	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;

	public List<Entrance> findAll() {
		return repository.findAll();
	}

	public Entrance findById(Long id) {
		Optional<Entrance> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public Entrance insert(Long userId, Entrance entrance) {
		Long categoryId = entrance.getCategory().getId();
		User user = userService.findById(userId);
		Category category = categoryService.findById(categoryId);
		user.adicionarEntrance(entrance);
		entrance.setUser(user);
		entrance.setCategory(category);
		category.addEntrance(entrance);
		return repository.save(entrance);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void updateDate(Entrance entranceOld, Entrance entranceUpg) {
		entranceOld.setValueEntrance(entranceUpg.getValueEntrance());
		entranceOld.setDescription(entranceUpg.getDescription());
		entranceOld.setCategory(entranceUpg.getCategory());
	}

	public Entrance updateEntrance(Long id, Entrance entrance) {
		Entrance EntranceOld = repository.getReferenceById(id);
		updateDate(EntranceOld, entrance);
		return repository.save(EntranceOld);
	}

}
