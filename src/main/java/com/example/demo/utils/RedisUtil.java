package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 操作redis工具类
 */
@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;
    private Jedis jedis=null;
    /**
     * 根据key从redis中获取值
     */
    public String get(String redisKey,int db){
        //获取连接
        try {
            jedis=jedisPool.getResource();
        }finally {
            if (null!=jedis){
                jedis.close();
            }

        }
        jedis.select(db);
        String value=jedis.get(redisKey);
        return value;
    }
    /**
     * 通过set设置值
     */
    public String set(String redisKey,String value,int db){
        //获取连接
        try {
            jedis=jedisPool.getResource();
        }finally {
            if (null!=jedis){
                jedis.close();
            }
        }
        jedis.select(db);
        String rlt=jedis.set(redisKey,value);
        return rlt;
    }

}
