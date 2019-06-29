package com.kayleoi.itoken.web.admin.service;

import com.kayleoi.itoken.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 去请求feign服务端itoken-service-admin中的服务接口
 * @Author kay三石
 * @date:2019/6/22
 */
@FeignClient(value="itoken-service-admin",fallback = AdminServiceFallback.class)
public interface AdminService {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "loginCode") String loginCode,@RequestParam(value = "password")String password);

}
