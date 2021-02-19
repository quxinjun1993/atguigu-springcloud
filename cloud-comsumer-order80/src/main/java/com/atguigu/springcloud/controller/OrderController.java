package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.payment.Payment;
import com.atguigu.springcloud.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://";

    private String SERVER_APPLICATION_NAME = "cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public ServerResponse create(@RequestBody Payment payment) {
        ServerResponse serverResponse = restTemplate.postForObject(PAYMENT_URL + SERVER_APPLICATION_NAME + "/payment/create", payment, ServerResponse.class);
        return serverResponse;
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public ServerResponse getPaymentById(@PathVariable("id") Long id) {
        log.info("当前服务为 -----  Consumer.Order  --------");
        ServerResponse serverResponse = restTemplate.getForObject(PAYMENT_URL + SERVER_APPLICATION_NAME + "/payment/getPaymentById/" + id, ServerResponse.class);
        return serverResponse;
    }
}
