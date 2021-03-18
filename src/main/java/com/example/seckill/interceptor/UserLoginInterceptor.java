package com.example.seckill.interceptor;

import com.example.seckill.entity.User;
import com.example.seckill.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：用户登录拦截器
 * 参数：
 * 作者：HuangJun
 * 时间：2021/3/16 14:33
 **/
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 重写的拦截器规则
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = cookieUtil.getCookieByName(request, "user");
        if (username != null) {
            User redisUser = (User) redisTemplate.opsForValue().get("user:" + username);

            if (redisUser != null) {
                return true;
            }
            return false;
        } else {
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
