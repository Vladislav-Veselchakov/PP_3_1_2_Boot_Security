package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
public class UserPageController {
    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPage(Model model, Authentication auth) {

        User user  = (User) auth.getPrincipal();
        Set<Role> roles = user.getRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "userPage";
    }
}  // public class UserPageController {
