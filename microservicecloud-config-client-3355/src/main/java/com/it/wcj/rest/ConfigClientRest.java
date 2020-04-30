package com.it.wcj.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 验证是否能从GitHub上读取配置信息
 * @Author wangchaojie
 * @Date 2020/4/30 9:34
 **/
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "applicationName:" + applicationName + "\t eurekaServers" + eurekaServers +
                "\t port" + port;
        System.out.println("str:" + str);
        return str;
    }
}
