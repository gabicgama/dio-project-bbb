package me.dio.coding.votacao.bbb.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.dio.coding.votacao.bbb.ms.model.VotingModel;

@Repository
public interface VotingRepository extends MongoRepository<VotingModel, String>{

}
