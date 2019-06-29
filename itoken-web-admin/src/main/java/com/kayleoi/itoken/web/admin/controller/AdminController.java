package com.kayleoi.itoken.web.admin.controller;

import com.kayleoi.itoken.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理员服务
 * @Author kay三石
 * @date:2019/6/22
 */
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        String json = adminService.login("", "");
        System.out.println(json);
        return "index";
    }

    /**
     * 注册
     * @return
     */
    public boolean register(){
        return false;
    }
}
