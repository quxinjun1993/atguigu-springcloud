package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.payment.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.insertSelective(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        log.info("id = {}", id);
        Payment payment = paymentDao.selectByPrimaryKey(id);
        log.info("payment = {}", payment);
        return payment;
    }
}
