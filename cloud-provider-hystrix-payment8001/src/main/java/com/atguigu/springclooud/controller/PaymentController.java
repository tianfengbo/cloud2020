package com.atguigu.springclooud.controller;

import com.atguigu.springclooud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Long id){
        String result = paymentService.paymentinfo_ok(id);
        log.info("*******result="+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id")Long id){
        String result = paymentService.paymentinfo_timout(id);
        log.info("*******result="+result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public String payment_circuit(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }

}
