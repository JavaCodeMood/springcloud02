package com.lhf.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用实现负载均衡
     * @param name
     * @return
     */
    public String hiService(String name) {
        System.out.println("name= " + name);
        return restTemplate.getForObject("http://EUREKA-CLIENT/index?name=" + name, String.class);
    }
}
