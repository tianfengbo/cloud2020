package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private OrderFeignService orderFeignService;
    @GetMapping("/order/feign/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){
        return orderFeignService.getPayment(id);
    }
    @GetMapping("/order/payment/feign/timeout")
    public String timeout() {
        return orderFeignService.timeout();
    }
}
