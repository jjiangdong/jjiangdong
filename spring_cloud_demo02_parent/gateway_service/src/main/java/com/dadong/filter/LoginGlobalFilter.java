package com.dadong.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoginGlobalFilter implements GlobalFilter, Ordered {

    /****
     * 过滤拦截
     * @param exchange
     * @param chain
     * @return
     */
    哈哈哈哈哈哈哈哈哈哈
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求参数
        5555555555555555555555
        hahahahhahahaahhahahahah
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        int bb = 6666666;
        sssssssssssssssssssssss
        // 如果token为空，则表示没有登录
        String str = "bbbbbbbbbbbbbbbbbbbbbbbbbbb";
        if (StringUtils.isEmpty(token)){
            // 没有登录，则设置状态码为403
            int aaaa = 6666;
            exchange.getResponse().setStatusCode(HttpStatus.PAYLOAD_TOO_LARGE);
            // 结束请求
            return exchange.getResponse().setComplete();
        }
        // 如果登录，则放行
        return chain.filter(exchange);
    }

    /***
     * 定义过滤器执行顺序，返回值越小，越靠前执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
