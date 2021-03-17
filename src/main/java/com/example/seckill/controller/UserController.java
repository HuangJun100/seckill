package com.example.seckill.controller;


import com.alibaba.druid.sql.visitor.functions.If;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.seckill.entity.User;
import com.example.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

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
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public String loginByUser(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              Model model) {
        /**
         * 首先查看redis中是否存在用户，如果存在，直接读取并对比，如果不存在则查询数据库后对比，正确后存入redis
         */
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "用户名或密码为空");
            return "redirect:/home";
        }
        User redisUser = (User) redisTemplate.opsForValue().get("user" + username);
        if (redisUser != null && password.equals(redisUser.getPassword())) {
            return "hello";
        }
        User dbUser = userService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getNickname, username));
        if (dbUser != null && dbUser.getPassword().equals(password)) {
            redisTemplate.opsForValue().set("user:" + dbUser.getNickname(), dbUser);
            return "hello";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "redirect:home";
        }
    }


    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

}
