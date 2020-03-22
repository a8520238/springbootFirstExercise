package com.example.demo.controller;

import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class studentController {

    @Autowired
    private studentService studentService;

    @GetMapping("/boot/update")
    public Object update() {
        return studentService.update();
    }

    @GetMapping("/boot/student")
    public Object student() {

        //Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                studentService.selectAll();
//            }
//        };

        //多线程测试缓存穿透
//        ExecutorService executorService = Executors.newFixedThreadPool(25);
//        for (int i = 0; i < 10000; i++) {
//            executorService.submit(runnable);
//        }
        return studentService.selectAll();
    }
}
