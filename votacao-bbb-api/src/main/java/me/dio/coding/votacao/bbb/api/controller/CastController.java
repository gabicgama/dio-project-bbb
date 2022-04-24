package me.dio.coding.votacao.bbb.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.CastModel;
import me.dio.coding.votacao.bbb.api.repository.CastRepository;

@RestController
@RequestMapping("/api/cast")
@AllArgsConstructor
@CrossOrigin
public class CastController {

	private final CastRepository repository;

	@PostMapping("/save")
	public ResponseEntity<CastModel> save(@RequestBody CastModel castModel) {
		CastModel entity = repository.save(castModel);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("/find")
	public ResponseEntity<CastModel> find(@RequestParam String key) {
		Optional<CastModel> optCastModel = repository.findById(key);
		if (optCastModel.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optCastModel.get());
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<CastModel>> findAll() {
		List<CastModel> list= repository.findAll();
		return ResponseEntity.ok(list);
	}
}
