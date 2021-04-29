package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "Zookeeper Payment:"+port+":"+ UUID.randomUUID();
    }
}
