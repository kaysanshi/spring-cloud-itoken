package com.kaysanshi.itoken.service.redis.service.impl;

import com.kaysanshi.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author kay三石
 * @date:2019/6/27
 */
@Service
public class RediServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, String value, long seconds) {
        redisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public void test(){
        //用 value 参数覆写(overwrite)给定 key 所储存的字符串值，从偏移量 offset 开始
        redisTemplate.opsForValue().set("name","hello word");
        redisTemplate.opsForValue().set("name","redis",6);
        System.out.println("***************"+redisTemplate.opsForValue().get("key"));//结果为 hello redis
        //为key设置它们的值，如果存在则返回false，不存在返回true
        redisTemplate.opsForValue().setIfAbsent("multi1","multi1");//false
        redisTemplate.opsForValue().setIfAbsent("multi111","multi111");//true  multi111之前不存在
        //为多个键分别设置它们的值
        Map<String,String> maps = new HashMap<String, String>();
            maps.put("multi1","multi1");
            maps.put("multi2","multi2");
            maps.put("multi3","multi3");
        redisTemplate.opsForValue().multiSet(maps);
        List<String> keys = new ArrayList<String>();
            keys.add("multi1");
            keys.add("multi2");
            keys.add("multi3");
        System.out.println(redisTemplate.opsForValue().multiGet(keys));


    }
}
