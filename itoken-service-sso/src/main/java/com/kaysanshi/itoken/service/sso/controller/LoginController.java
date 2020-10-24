package com.kaysanshi.itoken.service.sso.controller;

import com.kaysanshi.itoken.common.domain.TbSysUser;
import com.kaysanshi.itoken.common.utils.CookieUtils;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.service.sso.service.LoginServcie;
import com.kaysanshi.itoken.service.sso.service.consumer.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 视图解析返回页面
 * @Author kay三石
 * @date:2019/6/28
 */
@Controller
public class LoginController {

    @Autowired
    RedisService redisService;

    @Autowired
    LoginServcie loginServcie;

    /**
     * 登录,跳转登录页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String url,Model model, HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtils.getCookieValue(request, "token");

        // token 不为空可能已登录
        if (StringUtils.isNotBlank(token)) {
            //获得
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                String json = redisService.get(loginCode);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        TbSysUser tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                        // 已登录
                        if (tbSysUser != null) {
                            if (StringUtils.isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                        }

                        // 将登录信息传到登录页
                        model.addAttribute("tbSysUser", tbSysUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }

        return "login";
    }

    /**
     * 登录的业务
     * @param loginCode
     * @param url
     * @param passWord
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true)String loginCode, @RequestParam(required = false) String url,
                        @RequestParam(required = true)String passWord,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes){
//        TbSysUser user=loginServcie.login(loginCode,passWord);
////        if (user!=null){
////            //登录成功
////            String token= UUID.randomUUID().toString();
////            String result = redisService.put(token, loginCode, 60 * 60 * 24);
////          if (BaseResult.RESULT_OK.equals(result)){
////              CookieUtils.setCookie(request,response,"token",token);
////              return "redirect"+url;
////          }else{
////
////          }
////
////
////        }
////        return "login";
//        return  null;
        TbSysUser tbSysUser = loginServcie.login(loginCode, passWord);

        // 登录失败
        if (tbSysUser == null) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入");
        }

        // 登录成功
        else {
            String token = UUID.randomUUID().toString();

            // 将 Token 放入缓存
            String result = redisService.put(token, loginCode, 60 * 60 * 24);
            if (StringUtils.isNotBlank(result) && "ok".equals(result)) {
                //将token放入到cookie中
                CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
                if (StringUtils.isNotBlank(url)) {
                    return "redirect:" + url;
                }
            }

            // 熔断处理
            else {
                redirectAttributes.addFlashAttribute("message", "服务器异常，请稍后再试");
            }
        }

        return "redirect:/login";
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String url, Model model) {
        try {
            CookieUtils.deleteCookie(request, response, "token");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotBlank(url)) {
            return "redirect:/login?url=" + url;
        } else {
            return "redirect:/login";
        }
    }
}
