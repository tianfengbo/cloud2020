package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZkController {
    @Autowired
    private RestTemplate restTemplate;
    public static final String ZK_URI="http://cloud-provider-payment";

    @GetMapping("/order/payment/zk")
    public String orderZk(){
        String forObject = restTemplate.getForObject(ZK_URI+"/payment/zk", String.class);
        return forObject;
    }
}
