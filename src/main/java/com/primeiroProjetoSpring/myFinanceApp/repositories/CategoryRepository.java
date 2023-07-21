package com.primeiroProjetoSpring.myFinanceApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.primeiroProjetoSpring.myFinanceApp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT cat FROM Category cat WHERE cat.name LIKE %:name%")
    public List<Category> findByParts(@Param("name") String name);

}
