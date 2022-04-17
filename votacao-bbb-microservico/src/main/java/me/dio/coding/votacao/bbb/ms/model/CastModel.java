package me.dio.coding.votacao.bbb.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("participantes")
public class CastModel {

	@Id
	private String key;
	private String name;

}
