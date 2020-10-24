package com.kaysanshi.itoken.web.posts.service;

import com.kaysanshi.itoken.web.posts.service.fallback.RedisServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient(value = "itoken-service-redis",fallback = RedisServiceFallBack.class)
public interface RedisService {
    @RequestMapping(value = "put",method = RequestMethod.GET)
    public String put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String vlaue, @RequestParam(value = "seconds") long seconds);

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(@RequestParam(value = "key") String key);

}
