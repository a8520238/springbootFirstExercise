package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ThymeleafController {
    @GetMapping("/leaf/index")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("msg", "springboot集成thymeleaf");

        User user = new User();
        user.setId(1);
        user.setPhone("13888888888");
        user.setAddress("大连");
        user.setEmail("360@qq.com");

        model.addAttribute("user", user);

        List<User> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i <10; i++) {
            User u = new User();
            u.setId(i);
            u.setPhone("13888888888"+i);
            u.setAddress("大连"+i);
            u.setEmail("360@qq.com"+i);
            list.add(u);
            map.put(String.valueOf(i), u);
        }
        model.addAttribute("userList", list);
        model.addAttribute("userMap", map);
        model.addAttribute("userName", "zhangSan");
        model.addAttribute("sex", 1);
        model.addAttribute("date", new Date());

        request.setAttribute("name", "127.0.0.1");
        request.getSession().setAttribute("address", "dalian");

        return "leaf";
    }
}
