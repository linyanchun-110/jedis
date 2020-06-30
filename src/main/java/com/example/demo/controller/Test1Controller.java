package com.example.demo.controller;

import com.example.demo.resp.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.*;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Test1Controller {
    @RequestMapping("/test")
    public String test(Model model){
        List<Data> dataList=new ArrayList<Data>();
        Data data=new Data();
        data.setAuthor("林");
        data.setTitle("延");
        data.setUrl("www.baidu.com");
        dataList.add(data);
        model.addAttribute("learnList",dataList);
        return "Test";
    }

    public static void main(String[] args) {
//        Jedis jedis=new Jedis("127.0.0.1",6379);
//        jedis.set("testname","888");
//        System.out.println(jedis.get("testname"));


        //配置连接池信息
//        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
//        //设置最大连接数
//        jedisPoolConfig.setMaxTotal(20);
//        //构建连接池
//        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
//        //从连接池中获取连接
//        Jedis jedis=jedisPool.getResource();
//        System.out.println(jedis.get("testname"));
//        //将连接还回连接池
//        jedisPool.returnResource(jedis);
//        //释放连接池
//        jedisPool.close();

        //配置连接池信息
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(20);
        //定义集群信息
        List<JedisShardInfo> shards=new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1",6379));
        //定义集群连接池
        ShardedJedisPool shardedJedisPool=new ShardedJedisPool(jedisPoolConfig,shards);
        ShardedJedis shardedJedis=null;
        try {
           shardedJedis=shardedJedisPool.getResource();
            System.out.println(shardedJedis.get("testname"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=shardedJedis){
                shardedJedis.close();
            }
        }
         shardedJedisPool.close();
    }

}
