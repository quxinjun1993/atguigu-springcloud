package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.payment.Payment;
import com.atguigu.springcloud.response.ServerResponse;
import com.atguigu.springcloud.service.PaymentService;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public ServerResponse create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：{}", result);
        if (result > 0) {
            return ServerResponse.createBySuccess();
        } else {
            return ServerResponse.createByError();
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public ServerResponse getPaymentById(@PathVariable("id") Long id) {
        log.info("当前服务为 -----  provider.payment  --------");
        log.info("当前端口为：{}", serverPort);
        Payment payment = paymentService.getPaymentById(id);
        return ServerResponse.createBySuccess(payment);
    }


    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("element:{}", s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info("service:{}", "serviceId:" + serviceInstance.getServiceId()
                    + ",host:" + serviceInstance.getHost()+",port:" + serviceInstance.getPort()
                    + ",InstanceId:" + serviceInstance.getInstanceId()
                    + ",uri" + serviceInstance.getUri());
        }

        return this.discoveryClient;
    }
}
