package com.it.wcj.controller;

import com.it.wcj.entities.Dept;
import com.it.wcj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**实现服务发现**/
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("***"+list);
        //对应配置文件中的服务名
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservicecloud-provider-dept-8001");
        for (ServiceInstance instance:serviceInstances){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()
            +"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
