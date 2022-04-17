package me.dio.coding.votacao.bbb.ms.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacao.bbb.ms.model.CastModel;
import me.dio.coding.votacao.bbb.ms.model.VotingModel;
import me.dio.coding.votacao.bbb.ms.repository.VotingRepository;

@Service
@Slf4j
@AllArgsConstructor
public class VotingService {

	private final VotingRepository repository;

	@KafkaListener(topics = "voting", groupId = "MicroServiceVoting")
	private void execute(ConsumerRecord<String, String> register) {

		String personStr = register.value();
		log.info("novo voto recebido = {}", personStr);

		ObjectMapper mapper = new ObjectMapper();
		CastModel person = null;

		try {
			person = mapper.readValue(personStr, CastModel.class);
		} catch (JsonProcessingException ex) {
			log.error("Falha ao converter voto [{}]", personStr, ex);
			return;
		}

		VotingModel voting = new VotingModel(null, person, new Date());
		VotingModel entity = repository.save(voting);
		log.info("voto registrado com sucesso [id= {}, dataHora= {}]", entity.getId(), entity.getDateTime());
	}
}
