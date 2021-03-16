package com.example.seckill.config;

import com.example.seckill.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能：自定义MVC配置，包括拦截器注册
 * 参数：
 * 作者：HuangJun
 * 时间：2021/3/16 14:44
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    //拦截器注册到MVC中
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(userLoginInterceptor)
//                .addPathPatterns("/")
                .excludePathPatterns("/login");
    }

}
