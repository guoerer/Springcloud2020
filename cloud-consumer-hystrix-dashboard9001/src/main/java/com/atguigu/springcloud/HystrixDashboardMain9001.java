package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lijian
 * @create 2021-01-31 16:47
 */
@SpringBootApplication
@EnableHystrixDashboard  //Hystrix还提供了准实时的调用监控(Hystrix Dashboard)
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
