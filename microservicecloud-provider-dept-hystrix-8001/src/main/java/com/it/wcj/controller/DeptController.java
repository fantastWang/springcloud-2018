package com.it.wcj.controller;

import com.it.wcj.entities.Dept;
import com.it.wcj.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 如果没有抛出异常，触发了熔断器，则执行指定的方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("该ID:" + id + "没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable Long id) {
        return new Dept().setDeptno(id).setDname("该ID:" + id + "没有对应的信息,@HystrixCommand")
                .setDb_source("不存在的数据库");
    }
}
