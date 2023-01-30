package ru.kata.spring.restful.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.restful.models.Role;
import ru.kata.spring.restful.models.User;
import ru.kata.spring.restful.services.AdminService;
import ru.kata.spring.restful.services.RoleService;
import ru.kata.spring.restful.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class RESTController {

    private final AdminService adminService;
    private final UserService userService;
    private final RoleService roleService;


    public RESTController(AdminService adminService,
                          UserService userService,
                          RoleService roleService) {
        this.adminService = adminService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/api/admin")
    public ResponseEntity<List<User>> getUserForAdminPage() {
        System.out.println("Запрос пришел getUserForAdminPage()");
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/user")
    public ResponseEntity<User> getUser(Principal principal) {
        return new ResponseEntity<>(userService.loadUserByUsername(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @PostMapping(value = "/api/admin")
    public ResponseEntity<User> addUserAction(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/admin")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        adminService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        System.out.println("Запрос пришел deleteUser");
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
