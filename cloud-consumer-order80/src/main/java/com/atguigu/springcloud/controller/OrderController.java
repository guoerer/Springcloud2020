package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**订单类通过restTemplate类调用远程的服务接口方法
 * @author lijian
 * @create 2021-01-29 18:30
 */
@RestController
@Slf4j
public class OrderController {
   // public static final String PAYMENT_URL="http://localhost:8001";
    //通过访问eureka中注册的服务名进行远程调用服务
   public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    //消费端添加功能的实现，消费端通过restTemplate使用springCloud远程分步式服务地址
    @Resource
    private RestTemplate restTemplate;


    @PostMapping("/consumer/payment/create")
    //加@requestBody 注解后使用Postman工具只能使用Body 中带json数据提交，不能使用params参数提交测试
    public CommonResult<Payment> create(@RequestBody Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    //查询功能
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    //==> zipkin+sleuth,测试远程服务于调用链路过程
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }

}
