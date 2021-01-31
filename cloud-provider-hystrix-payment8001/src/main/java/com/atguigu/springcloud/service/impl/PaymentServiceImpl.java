package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lijian
 * @create 2021-01-31 14:23
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
       return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈";
    }

    //启用服务降级    超时降级演示
    @HystrixCommand(fallbackMethod = "payment_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000") //5秒钟以内就是正常的业务逻辑
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //int timeNumber = 3; //小于等于3秒算是正常情况
        int timeNumber = 15; //模拟非正常情况
        //int i = 1/0 ; //模拟非正常情况
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" payment_Timeout,id="+id+" \t o(╥﹏╥)o 耗时："+timeNumber;
    }


    //兜底方法，上面方法出问题是通过该方法进行处理，返回一个出错的信息
    public String payment_TimeoutHandler(Integer id){

        return "线程池"+Thread.currentThread().getName()+"payment_TimeoutHandler,系统繁忙,请稍后再试\t o(╥﹏╥)o ";

    }
}

