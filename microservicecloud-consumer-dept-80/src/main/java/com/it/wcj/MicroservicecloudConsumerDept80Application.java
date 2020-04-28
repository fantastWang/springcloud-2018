package com.it.wcj;

import com.it.myRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient  //表示是个客户端，向Eureka注册中心获取实例
//在服务启动时，加载自定义的Ribbon负载算法
@RibbonClient(name = "microservicecloud-provider-dept", configuration = MyRule.class)
public class MicroservicecloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept80Application.class, args);
    }
}
