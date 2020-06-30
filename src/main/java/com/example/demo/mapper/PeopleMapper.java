package com.example.demo.mapper;

import com.example.demo.model.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PeopleMapper {
    int insert(People record);

    int insertSelective(People record);

    List<People> queryAll();
}