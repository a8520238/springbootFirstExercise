package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.model.greet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//  /greeting页面controller

@RestController
public class greetController {
    private static final String template = "Hello啊, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public greet greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new greet(counter.incrementAndGet(), String.format(template, name));
    }

}
