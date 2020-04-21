package com.it.wcj.cfgBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration等同于注解版的applicationContext.xml
 */
@Configuration
public class ConfigBean {

    /**
     * RestTemplate提供了多种便捷访问远程Http服务的方法
     * 是一种简单便捷的访问Restful服务的模板类
     *
     * 使用RestTemplate访问restful接口非常简单
     * (url,requestMap,ResponseBean.class)这三个参数分别代表
     * Rest请求地址，请求参数，Http响应转换被转换成的对象类型
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
