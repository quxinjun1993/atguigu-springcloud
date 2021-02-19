package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.response.ServerResponse;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/feign/paymentById/{id}")
    public ServerResponse getPaymentInfoById(@PathVariable("id") Long id){
        ServerResponse serverResponse = paymentFeignService.getPaymentById(id);
        if(serverResponse.isSuccess()){
            return serverResponse;
        } else{
            return ServerResponse.createByError();
        }
    }
}
