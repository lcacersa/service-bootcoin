package com.everis.servicebootcoin.config;

import com.everis.servicebootcoin.handler.BootCoinHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(BootCoinHandler bootCoinHandler){

        return route(GET("/api/bootCoin"), bootCoinHandler::findAll)
                .andRoute(POST("/api/bootCoin"), bootCoinHandler::newBootCoin)
                .andRoute(PUT("/api/bootCoin/{id}"), bootCoinHandler::updateBootCoin)
                .andRoute(POST("/api/bootCoin/coinPurseBootCoin"), bootCoinHandler::newCoinPurseBootCoin);
    }

}
