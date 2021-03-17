package com.example.seckill.interceptor;

import com.example.seckill.config.JWTGenerator;
import com.example.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 功能：用户登录拦截器
 * 参数：
 * 作者：HuangJun
 * 时间：2021/3/16 14:33
 **/
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * 自定义拦截规则
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Autowired
    private JWTGenerator jwtGenerator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
//        拦截时可以做的其他操作
        String token = request.getHeader("token");
        User user = (User)request.getSession().getAttribute("user");
        if (user!=null && jwtGenerator.isVerify(user,token) ){
//        }
//        if (servletPath.startsWith("/") && request.getSession().getAttribute("User") == null) {
            request.getSession().setAttribute("errorMsg", "请登录");
            response.sendRedirect(request.getContextPath() + "/home");
            return false;
        } else {
            request.getSession().removeAttribute("erroeMsg");
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
