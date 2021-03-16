package com.example.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.seckill.entity.User;
import com.example.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author HuangJun
 * @since 2021-03-16
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginByUser(@RequestParam(name ="username") String username,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        //查询用户是否存在
        User dbUser = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getNickname, username));
        //如果存在的话，跳转hello，否则返回home页
        if(dbUser!=null && dbUser.getPassword().equals(password)){
            return "hello";
        }else{
        return "home";}
    }

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

}
