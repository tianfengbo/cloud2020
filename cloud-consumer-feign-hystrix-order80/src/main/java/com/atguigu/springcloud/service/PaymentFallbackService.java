package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentinfo_ok(Long id) {
        return "PaymentFallbackService-paymentinfo_ok /(ㄒoㄒ)/~~";
    }

    @Override
    public String payment_timeout(Long id) {
        return "PaymentFallbackService-payment_timeout /(ㄒoㄒ)/~~";
    }
}
