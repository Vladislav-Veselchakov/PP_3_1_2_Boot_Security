package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminUserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("addUser")
    public String addUserPage(ModelMap model) {
//        @DateTimeFormat(pattern = "yyyy-MM-dd", style = "aa", iso = "af")
//        private Date dateField;
        User user = new User();
        model.addAttribute("user", user);

        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, ModelMap model) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreated(df.format(new Date()));
        user.setModified(df.format(new Date()));

        userService.add(user);
        return ("redirect:/admin");
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Long id, ModelMap model) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

} // public class AdminUserController {
