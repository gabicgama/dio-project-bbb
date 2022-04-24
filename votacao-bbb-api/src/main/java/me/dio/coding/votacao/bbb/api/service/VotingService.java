package me.dio.coding.votacao.bbb.api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.CastModel;

@Service
@AllArgsConstructor
public class VotingService {

	private static final String TOPIC_VOTING = "voting";

	private final KafkaTemplate<Object, Object> template;

	public void addEvent(CastModel cast) {
		template.send(TOPIC_VOTING, cast);
	}
}
