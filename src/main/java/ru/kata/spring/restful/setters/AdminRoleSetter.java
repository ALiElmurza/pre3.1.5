package ru.kata.spring.restful.setters;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.restful.models.User;
import ru.kata.spring.restful.services.AdminService;
import ru.kata.spring.restful.services.UserService;

@Component
public class AdminRoleSetter implements ApplicationRunner {
    private AdminService adminService;
    private UserService userService;
    public AdminRoleSetter(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        User admin = new User("admin", "admin", "John", "Wick", 45, "wick@mail.ru");
        User user = new User("user", "user", "Kevin", "Bpk", 25, "waw@gmail.ru");
        adminService.saveAdmin(admin);
        userService.save(user);

    }
}
