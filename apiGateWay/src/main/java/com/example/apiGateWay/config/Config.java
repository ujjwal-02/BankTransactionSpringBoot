package com.example.apiGateWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/userauth/**").uri("http://localhost:8081"))
                .route(p -> p.path("/user/**").uri("http://localhost:8084"))
                .route(p -> p.path("/bankaccount/**").uri("http://localhost:8083"))
                .route(p -> p.path("/credit-card/**").uri("http://localhost:8082"))
                .build();
    }
}




