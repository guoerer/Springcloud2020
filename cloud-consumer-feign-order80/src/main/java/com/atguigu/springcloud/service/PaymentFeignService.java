package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**OpenFeign 接口不是，接口内的方法指明的是提供方客户端的具体实现方法
 * OpenFeign 通过指明接口和注解来表用消费者远程调用服务的方法，体现基于接口开发方式。相对于restTemplate基于类开发低耦合。易扩展
 * 指定远程服务调用微服务名称
 * @author lijian
 * @create 2021-01-30 22:01
 */
@Component      //将接口交给spring管理
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //指明接口是openfeign --同时指明我这个接口是调用的哪一个服务的方法
public  interface PaymentFeignService {
    //添加，接口上的注解和方法参数要和远程调用的相一致
    //特别注意：不能加泛型。
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);
    //查询
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "payment/feign/timeout")
    public String paymentFeignTimout();
}
