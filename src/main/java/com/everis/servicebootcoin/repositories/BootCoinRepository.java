package com.everis.servicebootcoin.repositories;

import com.everis.servicebootcoin.models.entities.BootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin,String> {
}
