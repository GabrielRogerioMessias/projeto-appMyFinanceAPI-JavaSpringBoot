package com.primeiroProjetoSpring.myFinanceApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.primeiroProjetoSpring.myFinanceApp.entities.User;
import com.primeiroProjetoSpring.myFinanceApp.entities.dto.UserDTO;
import com.primeiroProjetoSpring.myFinanceApp.repositories.UserRepository;
import com.primeiroProjetoSpring.myFinanceApp.services.exceptions.DatabaseException;
import com.primeiroProjetoSpring.myFinanceApp.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

//	public List<User> findAll() {
//		return repository.findAll();
//	}
//	

	public List<UserDTO> findAll() {
		List<User> listUsers = repository.findAll();
		List<UserDTO> listDTO = listUsers.stream().map(users -> new UserDTO(users)).collect(Collectors.toList());
		return listDTO;
	}


	public UserDTO findById(Long id) {
		User user = repository.findById(id).get();
		UserDTO userDTO = new UserDTO(user);
		if (user == null) {
			throw new ResourceNotFoundException(id);
		} else {
			return userDTO;
		}

	}

//	public User findById(Long id) {
//		Optional<User> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
//
//	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());

		}
	}

	public void updateDate(User userOld, User userUpg) {
		userOld.setName(userUpg.getName());
	}

	public User updateUser(Long id, User user) {
		User UserOld = repository.getReferenceById(id);
		updateDate(UserOld, user);
		return repository.save(UserOld);
	}


}
