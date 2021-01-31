package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lijian
 * @create 2021-01-30 21:58
 */
@SpringBootApplication
@EnableEurekaClient  //eureka客户端
@EnableFeignClients  //启用openFeign 功能，用于远程调用，基于接口开发方式。
public class OrderFeignMain80{
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}

