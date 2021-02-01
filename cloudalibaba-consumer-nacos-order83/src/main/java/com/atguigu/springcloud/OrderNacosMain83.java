package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lijian
 * @create 2021-02-01 21:37
 */
@SpringBootApplication
@EnableDiscoveryClient      //通用的注册中心
public class OrderNacosMain83 {
    public static void main(String[] args){
        SpringApplication.run(OrderNacosMain83.class,args);
    }

}
