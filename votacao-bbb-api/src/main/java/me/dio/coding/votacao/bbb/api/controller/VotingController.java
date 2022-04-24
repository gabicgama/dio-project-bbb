package me.dio.coding.votacao.bbb.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.CastModel;
import me.dio.coding.votacao.bbb.api.repository.CastRepository;
import me.dio.coding.votacao.bbb.api.service.VotingService;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
@CrossOrigin
public class VotingController {

	private final VotingService service;
	private final CastRepository repository;

	@PostMapping
	public ResponseEntity<CastModel> vote(@RequestBody CastModel cast) {
		Optional<CastModel> responseOpt = repository.findById(cast.getId());
		if(responseOpt.isEmpty()) {
			throw new RuntimeException("Código ["+ cast.getId() + "] inválido para votação!");
		}
		CastModel response = responseOpt.get();
		service.addEvent(response);
		return ResponseEntity.ok(response);
	}
}
