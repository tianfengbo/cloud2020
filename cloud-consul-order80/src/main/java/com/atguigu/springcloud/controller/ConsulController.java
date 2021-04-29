package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulController {
    @Autowired
    private RestTemplate restTemplate;
    public static final String CONSUL_URI="http://consul-provider-payment";
    @GetMapping("/order/payment/consul")
    public String orderZk(){
        String forObject = restTemplate.getForObject(CONSUL_URI+"/payment/consul", String.class);
        return forObject;
    }
}
