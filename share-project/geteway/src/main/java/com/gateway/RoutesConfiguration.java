package com.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @author w2gd
 * @description: 路由配置
 */
// @Configuration
public class RoutesConfiguration {
    // @Bean
    public RouteLocator declare (RouteLocatorBuilder builder) {
        return builder.routes()
                .route("id-001", route -> route.path( "/users/**")
                    .and().method(HttpMethod.GET)
                    .uri("http://Localhost:8081"))
                .route("id-002", route -> route.path("/shares/**")
                    .uri("http://localhost:8082"))
                .build();
    }
}
