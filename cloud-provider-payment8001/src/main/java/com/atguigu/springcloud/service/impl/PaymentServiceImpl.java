package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lijian
 * @create 2021-01-29 14:42
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired  //先bytype,后by name
    //@Resource   jdk注解，先byname
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }

}
