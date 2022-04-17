package me.dio.coding.votacao.bbb.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.CastModel;
import me.dio.coding.votacao.bbb.api.service.VotingService;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
public class VotingController {

	private final VotingService service;

	@PostMapping
	public ResponseEntity<String> vote(@RequestBody CastModel person) {
		service.addEvent(person);
		return ResponseEntity.ok("Voto computado");
	}
}
