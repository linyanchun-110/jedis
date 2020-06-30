package com.example.demo.service.impl;

import com.example.demo.mapper.PeopleMapper;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;
    @Override
    public String test() {
        return peopleMapper.queryAll().get(0).getName();
    }
}
