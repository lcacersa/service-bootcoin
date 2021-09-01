package com.everis.servicebootcoin.repositories;

import com.everis.servicebootcoin.models.entities.CoinPurseBootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CoinPurseBootCoinRepository extends ReactiveMongoRepository<CoinPurseBootCoin,String> {
}
