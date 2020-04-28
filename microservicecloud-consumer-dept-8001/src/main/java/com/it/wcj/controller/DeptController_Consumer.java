package com.it.wcj.controller;

import com.it.wcj.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX="http://localhost:8001";
    //三个服务提供者的应用名配给一致的，这样Ribbon负载均衡的时候就可以负载访问了
    private static final String REST_URL_PREFIX = "http://microservicecloud-provider-dept";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用RestTemplate访问restful接口非常简单
     * (url,requestMap,ResponseBean.class)这三个参数分别代表
     * Rest请求地址，请求参数，Http响应转换被转换成的对象类型
     */
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
