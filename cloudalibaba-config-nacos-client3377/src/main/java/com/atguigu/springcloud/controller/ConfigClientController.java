package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijian
 * @create 2021-02-01 22:10
 */
@RestController
@RefreshScope      //自动刷新配置文件的信息
public class ConfigClientController {
    @Value("${config.info}") //通过nacos云端配置:nacos-config-client-dev.yaml
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
