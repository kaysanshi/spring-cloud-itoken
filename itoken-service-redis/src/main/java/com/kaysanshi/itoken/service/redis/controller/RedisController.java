package com.kaysanshi.itoken.service.redis.controller;

import com.kaysanshi.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay三石
 * @date:2019/6/27
 */
@RestController
public class RedisController {
    private static final String RESULT_OK="ok";

    @Autowired
    private RedisService redisService;

    /**
     * set关键字
     * @param key
     * @param value
     * @param seconds 超时时间
     * @return
     */
    @RequestMapping(value = "put", method = RequestMethod.GET)
    public String set(String key, String value, long seconds) {
        redisService.set(key, value, seconds);
        return RESULT_OK;
    }

    /**
     * 取关键字
     * @param key
     * @return
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String find(String key) {
        String json = null;

        Object obj = redisService.get(key);
        if (obj != null) {
            json = (String) redisService.get(key);
        }

        return json;
    }
}
