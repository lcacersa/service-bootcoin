package com.everis.servicebootcoin.services.imp;

import com.everis.servicebootcoin.models.entities.BootCoin;
import com.everis.servicebootcoin.repositories.BootCoinRepository;
import com.everis.servicebootcoin.services.IBootCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinImp implements IBootCoinService {

    private static final Logger LOGGER  =   LoggerFactory.getLogger(BootCoin.class);

    @Autowired
    private BootCoinRepository repository;

    @Override
    public Mono<BootCoin> create(final BootCoin bootCoin) {
        return repository.save(bootCoin);
    }

    @Override
    public Flux<BootCoin> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<BootCoin> findById(final String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<BootCoin> update(final BootCoin bootCoin) {
        return repository.save(bootCoin);
    }

    @Override
    public Mono<Void> delete(BootCoin o) {
        return null;
    }
}
