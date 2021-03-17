package com.example.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    /**
     *
     */
    @GetMapping("/welcom")
    public String hello(Model model){
        model.addAttribute("name","hello");
        return "welcom";
    }
}
