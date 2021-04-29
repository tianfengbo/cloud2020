package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsulController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/payment/consul")
    public String consul(){
        return "spring cloud port:"+port+ UUID.randomUUID();
    }
}
