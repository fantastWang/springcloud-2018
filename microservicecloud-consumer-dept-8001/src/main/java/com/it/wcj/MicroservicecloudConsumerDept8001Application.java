package com.it.wcj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //表示是个客户端，向Eureka注册中心获取实例
public class MicroservicecloudConsumerDept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept8001Application.class, args);
    }
}
