package com.litao.coupon.customer;


import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configration {
    @Bean
    Logger.Level feignLogger(){return Logger.Level.FULL;}
}
