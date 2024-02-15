package com.sk.gateway.route;

import com.alibaba.fastjson.JSON;
import com.sk.gateway.filter.RequestFilter;
import com.sk.gateway.filter.TestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 7:49 PM
 */
@EnableAutoConfiguration
@Configuration
public class ApiRouteLocator {
    @Autowired
    private RequestFilter requestFilter;
    @Autowired
    private TestFilter testFilter;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator routeLocator = routes.route("user-provider", predicateSpec -> {
                            return predicateSpec.method(HttpMethod.POST)
                                    .and()
                                    .path("/api/user/**")
                                    .filters(f -> {
                                        f.stripPrefix(1).filter(requestFilter).filter(testFilter)
                                                .modifyRequestBody(Map.class, Map.class,MediaType.APPLICATION_JSON_VALUE,(exchange, s) -> {
                                                    return request(s, exchange);
                                                }).modifyResponseBody(Map.class,Map.class,(a,b)->{
                                                    b.put("返回报文","ok");
                                                    return Mono.just(b);
                                                });
                                        return f;
                                    })
                                    .uri("lb://user-provider");
                        }
                ).route("order-provider", predicateSpec -> predicateSpec.method(HttpMethod.GET)
                        .and()
                        .path("/api/order/**")
                        .filters(f -> {
                            f.stripPrefix(1).filter(requestFilter);
                            return f;
                        }).uri("lb://order-provider"))
                .build();
        return routeLocator;
    }

    public Mono request(Map data, ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        data.put("id","123");
        return Mono.just(data);
        /*DataBuffer bodyDataBuffer = response.bufferFactory().wrap(JSON.toJSONBytes(data));
        return response.writeWith(Mono.just(bodyDataBuffer));*/
    }
}
