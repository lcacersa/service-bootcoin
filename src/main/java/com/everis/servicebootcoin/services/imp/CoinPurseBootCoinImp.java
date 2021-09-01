package com.everis.servicebootcoin.services.imp;

import com.everis.servicebootcoin.models.entities.CoinPurseBootCoin;
import com.everis.servicebootcoin.repositories.CoinPurseBootCoinRepository;
import com.everis.servicebootcoin.services.ICoinPurseBootCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoinPurseBootCoinImp implements ICoinPurseBootCoinService {

    private static final Logger LOGGER  =   LoggerFactory.getLogger(CoinPurseBootCoin.class);

    @Autowired
    private CoinPurseBootCoinRepository repository;

    @Override
    public Mono<CoinPurseBootCoin> create(final CoinPurseBootCoin coinPurseBootCoin) {
        return repository.save(coinPurseBootCoin);
    }

    @Override
    public Flux<CoinPurseBootCoin> findAll() {
        return null;
    }

    @Override
    public Mono<CoinPurseBootCoin> findById(String s) {
        return null;
    }

    @Override
    public Mono<CoinPurseBootCoin> update(CoinPurseBootCoin o) {
        return null;
    }

    @Override
    public Mono<Void> delete(CoinPurseBootCoin o) {
        return null;
    }
}
