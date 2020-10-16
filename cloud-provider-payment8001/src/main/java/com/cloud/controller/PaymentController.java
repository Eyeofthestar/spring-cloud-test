package com.cloud.controller;

import com.api.cloud.pojo.CommentResult;
import com.api.cloud.pojo.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * 模拟订单的生产者
 */
@RestController
@Slf4j   //@Slf4j  打印日志  === private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/creat")
    public CommentResult creat(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommentResult(200, "插入数据成功", result);
        }
        return new CommentResult(500, "插入数据失败", null);
    }


    @GetMapping("/payment/getPayment")
    public CommentResult getPayment(Integer id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        log.info("查询结果:" + payment.toString());
        if (payment != null) {
            return new CommentResult(200, "查询成功", payment);
        }
        return new CommentResult(500, "查询失败", null);
    }
}
