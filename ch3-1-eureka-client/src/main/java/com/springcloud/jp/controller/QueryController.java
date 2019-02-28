package com.springcloud.jp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RefreshScope
@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;
    @GetMapping("/eureka-server")
    public Object getEurekaServerUrl(){
        return eurekaClientConfigBean.getServiceUrl();
    }

    @Value("${spring.application.name}")
    public String name;

    @GetMapping("/tsts")
    public String tsts(){
        return "nihao "+name;
    }



}
