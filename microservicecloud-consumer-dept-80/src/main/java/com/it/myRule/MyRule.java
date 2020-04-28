package com.it.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule myRuble() {
        //return new RandomRule();
        return new RandomRule_C();
    }
}
