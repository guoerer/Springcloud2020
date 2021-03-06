package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lijian
 * @create 2021-01-31 14:21
 */

public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    //测试服务降级
    public String paymentInfo_TimeOut(Integer id);

    //测试服务熔断
    public String paymentCircuitBreaker(Integer id);
}
