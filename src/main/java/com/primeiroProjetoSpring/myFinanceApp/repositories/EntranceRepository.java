package com.primeiroProjetoSpring.myFinanceApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.primeiroProjetoSpring.myFinanceApp.entities.Entrance;

public interface EntranceRepository extends JpaRepository<Entrance,Long>{

	
	@Query("SELECT ent FROM Entrance ent WHERE ent.description LIKE %:description%")
	public List<Entrance> findByParts(@Param("description")String description);
}
