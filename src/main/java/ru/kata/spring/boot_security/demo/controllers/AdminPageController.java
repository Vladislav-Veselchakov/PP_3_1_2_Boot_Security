package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class AdminPageController {
    @PersistenceContext
    EntityManager entityManager;

    private UserService userService;
    private RoleService roleService;

    public AdminPageController(UserService service, RoleService roleService) {
        this.userService = service;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String AdminPage(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        List<Role> roles = roleService.getRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("result001", "result001");

        List<Object> userRole = (List<Object>) entityManager.createNativeQuery(
    "                    SELECT u.name as user, ur.User_id, ur.Role_id, r.name as role\n" +
            "                    FROM user_role as ur\n" +
            "                    LEFT JOIN users as u\n" +
            "                        ON ur.User_id = u.id\n" +
            "                    LEFT JOIN roles as r\n" +
            "                        ON ur.Role_id = r.id\n").getResultList();
        model.addAttribute("userRole", userRole);

        return "adminPage";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}