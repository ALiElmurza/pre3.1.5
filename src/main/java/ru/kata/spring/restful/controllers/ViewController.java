package ru.kata.spring.restful.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    @GetMapping("/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_page");
        return modelAndView;
    }
}
