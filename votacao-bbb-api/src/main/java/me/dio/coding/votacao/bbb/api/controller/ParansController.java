package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.coding.votacao.bbb.api.model.ParansModel;
import me.dio.coding.votacao.bbb.api.repository.ParansRepository;

@RestController
@RequestMapping("/api/parans")
public class ParansController {

	private final ParansRepository repository;

	public ParansController(ParansRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/save")
	public ResponseEntity<ParansModel> save(@RequestBody ParansModel paransModel) {
		ParansModel entity = repository.save(paransModel);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("/find")
	public ResponseEntity<ParansModel> find(@RequestParam String key) {
		Optional<ParansModel> optParansModel = repository.findById(key);
		if (optParansModel.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optParansModel.get());
	}
}
