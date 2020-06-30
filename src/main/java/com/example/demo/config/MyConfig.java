package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class MyConfig {
    @Value("${demo.userName}")
    private String userName;
    @Value("${demo.password}")
    private String password;
    @Value("${demo.url}")
    private String url;

}
