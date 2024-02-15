package com.sk.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author Hugo.Wwg
 * @Since 2019-05-03
 */
@Component
public class TestFilter implements GatewayFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(TestFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("TestFilter.filter start");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = request.getHeaders();
       /* if(true){
            DataBuffer bodyDataBuffer = response.bufferFactory().wrap("吴才强".getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(bodyDataBuffer));
        }*/
        Mono mono=chain.filter(exchange.mutate().request(request).build());
        logger.info("TestFilter.filter end");
        return mono;

    }


    @Override
    public int getOrder() {
        return 2;
    }


}
