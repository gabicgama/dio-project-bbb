package me.dio.coding.votacao.bbb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.dio.coding.votacao.bbb.api.model.ParansModel;

@Repository
public interface ParansRepository extends MongoRepository<ParansModel, String> {

}
