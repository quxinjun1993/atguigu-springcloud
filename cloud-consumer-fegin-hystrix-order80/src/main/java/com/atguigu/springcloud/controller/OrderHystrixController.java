package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@DefaultProperties()  这个注解可配置统一的降级方法 @HystrixCommand中如果没有标注回调方法名称就会调用此方法
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_handle",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="6000")
//    })
    public String payment_timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        return result;
    }

}
