package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lijian
 * @create 2021-01-30 20:58
 */
@SpringBootApplication
@EnableEurekaClient  //作为eureka客户端启用，注册自己到eureka 上面
@MapperScan("com.atguigu.springcloud.dao")
@EnableTransactionManagement
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }

}
