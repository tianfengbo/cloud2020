package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i>0){
            log.info("插入成功哈哈哈哈");
            return new CommonResult(200,"插入成功 port="+port,i);
        }else {
            log.info("插入失败");
            return new CommonResult(444,"插入失败");
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            log.info("哈哈哈查询成功;id为"+id);
            return new CommonResult(200,"查询成功 port="+port,payment);
        }else {
            log.info("查询失败");
            return new CommonResult(444,"查询失败");
        }
    }
    @GetMapping("/payment/feign/timeout")
    public String timeout() {
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return port;
    }
}
