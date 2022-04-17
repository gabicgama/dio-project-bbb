package me.dio.coding.votacao.bbb.ms.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("votacao")
public class VotingModel {

	@Id
	private String id;
	private CastModel person;
	private Date dateTime;
}
