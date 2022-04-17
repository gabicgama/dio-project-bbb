package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.dio.coding.votacao.bbb.api.model.CastModel;

@Repository
public interface CastRepository extends MongoRepository<CastModel, String> {

}
