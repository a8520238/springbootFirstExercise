package com.example.demo.controller;

import com.example.demo.model.greet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {

    @RequestMapping("/boot/user/{id}")
    //@PathVariable 实现RESTFull设计
    public Object greet(@PathVariable("id") Integer id) {
        greet greet = new greet(id, "张三");
        return greet;
    }

}
