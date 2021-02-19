package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //当前注解是为了让 RestTemplate 具备负载均衡的能力，不在关注端口号，只关注服务名称
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
