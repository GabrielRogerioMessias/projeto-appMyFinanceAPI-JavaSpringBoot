package com.primeiroProjetoSpring.myFinanceApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

	
	

}

