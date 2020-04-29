package com.it.wcj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer     //开启Config分布式配置服务
public class Microservicecloud3344Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservicecloud3344Application.class, args);
    }
}