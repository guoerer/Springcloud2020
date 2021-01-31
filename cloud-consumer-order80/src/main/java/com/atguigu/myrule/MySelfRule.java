package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**自定义ribbon 负载均衡的请求规则（默认规则是轮询）
 * @author lijian
 * @create 2021-01-30 21:32
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//设置负载均衡策略是随机
    }
}
