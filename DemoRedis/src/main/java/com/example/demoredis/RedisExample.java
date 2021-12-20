package com.example.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RedisExample implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        valueExample();
        listExample();
    }
    public void valueExample(){
        redisTemplate.opsForValue().set("key1", "value_1");
        System.out.println("value: " + redisTemplate.opsForValue().get("key1"));
    }

    public void listExample(){
        List<String> list = new ArrayList<>();
        list.add("index1_s");
        list.add("index2_sd");
        redisTemplate.opsForList().rightPushAll("listExample()","list", "jcce", "nsw");
        System.out.println(list);
        redisTemplate.opsForList().rightPushAll("list1",list);
        System.out.println("Listredis: "+ redisTemplate.opsForList().size("list1"));
        System.out.println(redisTemplate.opsForList().range("list1",0,10));
    }

}
