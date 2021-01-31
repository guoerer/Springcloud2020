package com.atguigu.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**注解类，远程调用方法。
 * spring could 远程调用的实现：http+json格式
 * @author lijian
 * @create 2021-01-29 15:34
 */
@SpringBootConfiguration
public class ApplicationContextConfig {
    /**
     * restTemplate 提供了多种便捷访问调用远程http服务的方法，是一种便捷访问restful服务的模板类
     * 是spring提供用于访问rest服务的客户端模板工具类
     * @return
     */
    @Bean           //作为一个bean对象交给spring容器管理
    @LoadBalanced   //ribbon提供的负载均衡，通过注册中心eureka(默认集成了ribbon服务)获取服务列表，远程调用
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();

    }
}
