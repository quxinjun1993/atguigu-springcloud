package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPost;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("***** result：{}", result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("***** result：{}", result);
        return result;
    }


    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String payment_circuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.payment_circuitBreaker(id);
        log.info("***** result：{}", result);
        return result;
    }
}
