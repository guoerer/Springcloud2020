package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lijian
 * @create 2021-01-29 14:29
 */
@Data  //get/set方法
@AllArgsConstructor //有参构造
@NoArgsConstructor  //无参构造
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
