package com.atguigu.springcloud.fallback;

import com.atguigu.springcloud.services.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----->   paymentInfo_OK method fallback";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----->   paymentInfo_Timeout method fallback";
    }
}
