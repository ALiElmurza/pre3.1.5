package ru.kata.spring.restful.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.restful.models.User;
import ru.kata.spring.restful.services.AdminService;
import ru.kata.spring.restful.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private final AdminService adminService;
    private final UserService userService;


    public RESTController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
