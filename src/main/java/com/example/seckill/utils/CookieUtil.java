package com.example.seckill.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 功能：
 * 参数：
 * 作者：HuangJun
 * 时间：2021/3/17 16:29
 **/
@Component
public class CookieUtil {

    public String getCookieByName(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        for(Cookie cukie:cookies){
            cukie.getName().equals(name);
            return cukie.getValue();
        }
        return null;
    }
}
