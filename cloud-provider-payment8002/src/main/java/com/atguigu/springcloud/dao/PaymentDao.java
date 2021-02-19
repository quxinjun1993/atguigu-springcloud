package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.base.BaseDao;
import com.atguigu.springcloud.entities.payment.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseDao<Payment> {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
