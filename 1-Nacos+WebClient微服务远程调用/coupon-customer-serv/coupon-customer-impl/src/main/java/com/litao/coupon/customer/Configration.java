package com.litao.coupon.customer;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configration {
    /**
     * 注册一个WebClient的实例用来远程调用
     * @return WebClient.Builder
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder register(){
        return WebClient.builder();
    }
}
