package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//jsp页面和thymeleaf不能同时开启
@Controller
public class JSPController {

    @GetMapping("/jsp/index")
    public String index (Model model){
        model.addAttribute( "msg", "testJSP" );
        return "index";
    }
}
