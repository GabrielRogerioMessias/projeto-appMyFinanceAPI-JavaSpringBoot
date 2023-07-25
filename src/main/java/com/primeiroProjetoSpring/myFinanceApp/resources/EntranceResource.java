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

import com.primeiroProjetoSpring.myFinanceApp.entities.Entrance;
import com.primeiroProjetoSpring.myFinanceApp.services.EntranceService;

@RestController
@RequestMapping(value = "/entrances")
public class EntranceResource {

	@Autowired
	private EntranceService service;

	@GetMapping
	public ResponseEntity<List<Entrance>> findAll() {
		List<Entrance> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrance> findById(@PathVariable Long id) {
		Entrance ent = service.findById(id);
		return ResponseEntity.ok().body(ent);
	}

	@PostMapping(value = "/{userId}/addEntrance")
	public ResponseEntity<Entrance> insert(@PathVariable Long userId, @RequestBody Entrance entrance) {
		Entrance newEntrance = service.insert(userId, entrance);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entrance.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newEntrance);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Entrance> update(@PathVariable Long id, @RequestBody Entrance entranceUpda) {
		Entrance entran = service.updateEntrance(id, entranceUpda);
		return ResponseEntity.ok().body(entran);

	}

	@GetMapping(value = "/findparts/{description}")
	public ResponseEntity<List<Entrance>> findByParts(@PathVariable String description) {
		List<Entrance> list = service.findByParts(description);
		return ResponseEntity.ok().body(list);
	}

}
