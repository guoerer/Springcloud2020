package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author lijian
 * @create 2021-01-29 14:46
 */
@RestController
@Slf4j  //框架日志
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){ //埋雷
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result>0){  //成功
            CommonResult commonResult = new CommonResult(2000, "插入数据库成功" + port, result);
            return commonResult;
        }else {
            return new CommonResult(4440,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult(2000,"查询成功"+port,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }

    /**
     * 测试openFeign 超时控制。openFeign 远程默认调用时间是1秒，程序超过1秒后会自动报错。
     * @return
     */
    @GetMapping(value = "payment/feign/timeout")
    public String paymentFeignTimout(){
        try {
            TimeUnit.SECONDS.sleep(3);//让程序睡3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    /**
     * 测试服务链路调用过程的监控组件===sleuth+zipkin
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi ,i'am paymentzipkin server，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
