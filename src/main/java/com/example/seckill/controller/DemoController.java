package com.example.seckill.controller;

import com.example.seckill.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.Arrays;
import java.util.stream.Stream;

@Controller
@Slf4j
public class DemoController {

    /**
     *
     */


    @GetMapping("/welcome")
    public String hello(Model model,
                        HttpServletRequest request){

        model.addAttribute("name","hello");
        return "welcome";
    }
}
