package com.everis.servicebootcoin.handler;

import com.everis.servicebootcoin.models.entities.BootCoin;
import com.everis.servicebootcoin.models.entities.CoinPurseBootCoin;
import com.everis.servicebootcoin.services.IBootCoinService;
import com.everis.servicebootcoin.services.ICoinPurseBootCoinService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j(topic = "bootCoin_handler")
@Component
public class BootCoinHandler {

    @Autowired
    private IBootCoinService service;

    @Autowired
    private ICoinPurseBootCoinService serviceCoinPurse;

    private static final Logger LOGGER = LoggerFactory.getLogger(BootCoin.class);


    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), BootCoin.class);
    }

    public Mono<ServerResponse> newBootCoin(ServerRequest request) {
        Mono<BootCoin> bootCoinMono = request.bodyToMono(BootCoin.class);

        return bootCoinMono.flatMap( bootCoin ->
            {return service.create(bootCoin);})
                .flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(c))
                ).switchIfEmpty(ServerResponse.badRequest().build());
    }

    public Mono<ServerResponse> updateBootCoin(ServerRequest request) {
        Mono<BootCoin> bootCoinMono = request.bodyToMono(BootCoin.class);
        String id = request.pathVariable("id");

        return service.findById(id).zipWith(bootCoinMono, (db,req) -> {
            db.setBuy(req.getBuy());
            db.setSell(req.getSell());
            return db;
        }).flatMap( c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.update(c),BootCoin.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> newCoinPurseBootCoin(ServerRequest request) {
        Mono<CoinPurseBootCoin> coinPurseBootCoinMono = request.bodyToMono(CoinPurseBootCoin.class);

        return coinPurseBootCoinMono.flatMap( coinPurseBootCoin ->
        {return serviceCoinPurse.create(coinPurseBootCoin);})
                .flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(c))
                ).switchIfEmpty(ServerResponse.badRequest().build());
    }
}
