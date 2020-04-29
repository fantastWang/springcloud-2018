package com.it.wcj.service;

import com.it.wcj.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description Feign服务降级：当有被调用者宕机，无法被调用时，执行该方法
 * 整体资源不够了，忍痛将某些资源先关闭
 * @Author wangchaojie
 * @Date 2020/4/29 14:01
 **/
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID:" + id + "没有对应的信息,Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setDb_source("不存在的数据库");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
