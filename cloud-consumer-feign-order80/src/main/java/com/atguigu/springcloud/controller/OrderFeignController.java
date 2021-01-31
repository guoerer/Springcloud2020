package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijian
 * @create 2021-01-30 22:16
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @PostMapping("/consumer/payment/create")
    //加@requestBody 注解后使用Postman工具只能使用Body 中带json数据提交，不能使用params参数提交测试
    public CommonResult<Payment> create(@RequestBody Payment payment){

        CommonResult commonResult = paymentFeignService.create(payment);
        return commonResult;
    }
    //查询功能
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    /**
     * 远程方式调用服务端超时方法的测试
     * @return
     */
    @GetMapping("/consumer/feign/getTimeout")
    public String getTimeout(){
        return paymentFeignService.paymentFeignTimout();

    }
}
