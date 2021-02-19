package com.atguigu.springcloud.service;

import com.atguigu.springcloud.response.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    ServerResponse getPaymentById(@PathVariable("id") Long id);


}
