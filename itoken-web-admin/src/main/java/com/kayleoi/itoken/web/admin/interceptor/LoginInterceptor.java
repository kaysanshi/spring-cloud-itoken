package com.kayleoi.itoken.web.admin.interceptor;

import com.kayleoi.itoken.common.utils.CookieUtils;
import com.kayleoi.itoken.common.utils.StringUtils;
import com.kayleoi.itoken.web.constants.WebConstants;
import com.kayleoi.itoken.web.admin.service.RedisService;
import com.kayleoi.itoken.web.interceptor.BaseInterceptorMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现redis的服务取数据，是否登录
 *
 * @Author kay三石
 * @date:2019/6/28
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在这里需要用到一个redis服务
     */
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return BaseInterceptorMethods.preHandleForLogin(request, response, handler, "http://localhost:8601/" + request.getServletPath());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                BaseInterceptorMethods.postHandleForLogin(request, response, handler, modelAndView, redisService.get(loginCode), "http://localhost:8601/" + request.getServletPath());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
