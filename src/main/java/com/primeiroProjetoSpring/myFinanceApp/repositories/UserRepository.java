package com.primeiroProjetoSpring.myFinanceApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeiroProjetoSpring.myFinanceApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	

}
