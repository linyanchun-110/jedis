package com.example.demo.controller;

import com.example.demo.config.MyConfig;
import com.example.demo.config.RedisConfig;
import com.example.demo.config.YmlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private MyConfig myConfig;
    @Autowired
    private YmlConfig ymlConfig;
    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }
    @RequestMapping("/hello1")
    public String test1(){
        String userName=myConfig.getUserName();
        String password=myConfig.getPassword();
        String url=ymlConfig.getUrl();
        return url;
    }
}
