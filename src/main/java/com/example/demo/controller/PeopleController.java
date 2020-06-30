package com.example.demo.controller;
import com.example.demo.service.PeopleService;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private PeopleService peopleService;
    @RequestMapping("/people")
    public String test(){
        String name=peopleService.test();
        String redisKey="lin";
        redisUtil.set(redisKey,name,0);
        String value=redisUtil.get("testname",0);
        return value;
    }
}
