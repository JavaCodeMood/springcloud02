package com.lhf.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient   //注册服务客户端
@EnableDiscoveryClient  //向服务中心注册
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String name;

    @RequestMapping("/index")
    public String index(@RequestParam(value="name", defaultValue = "Spring Cloud")String name){
        return "<h1>name : </h1> " + name + " , <h1>port : </h1>" + port;
    }


}

