package com.cloud.controller;

import com.api.cloud.pojo.CommentResult;
import com.api.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

//    restTemplate  Spring  提供的用于远程接口访问的在封装工具
    @Resource
    private RestTemplate restTemplate;

    private static final String  PAYMENT_URL ="http://127.0.0.1:8001";

    //   直接使用restTemplate.postForObject 调用插入方法可以成功但是导致生产者接受不到参数payment
    //   生产者需要使用注解     @RequestBody 接收参数    
    @GetMapping("/consumer/payment/creat")
    public CommentResult creat(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/creat",payment,CommentResult.class);
    }

    @GetMapping("/consumer/payment/getPayment")
    public CommentResult getPayment(Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment?id="+id,CommentResult.class);
    }
}
