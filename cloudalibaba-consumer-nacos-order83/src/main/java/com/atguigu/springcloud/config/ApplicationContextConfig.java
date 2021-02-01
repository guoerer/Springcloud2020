package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**使用restTemple方式进行远程调用
 * @author lijian
 * @create 2021-02-01 21:38
 */
@Configuration
public class ApplicationContextConfig {
    @Bean   //作为一个bean对象交个spring管理
    @LoadBalanced       //ribbon 负载均衡策略
    public RestTemplate getRestTemplet(){
        return new RestTemplate();

    }
}
