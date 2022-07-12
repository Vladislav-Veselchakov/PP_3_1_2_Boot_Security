package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;

import javax.management.modelmbean.ModelMBean;

@Controller
@RequestMapping("/admin")
public class AdminRoleController {
    private final RoleService roleService;

    public AdminRoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/addRole")
    public String addRole(ModelMap model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "addRole";
    }

    @PostMapping("/addRole")
    public String addRole(@ModelAttribute("role") Role role, ModelMap model) {
        roleService.add(role);
        return ("redirect:/admin");
    }

    @GetMapping("/deleteRole")
    public String deleteRole(@RequestParam("id") Long id, ModelMap model) {
        roleService.deleteRole(id);
        return  ("redirect:/admin");
    }

    @GetMapping("editRole")
    public String editRolePage(@RequestParam("id") Long id, ModelMap modelMap) {
        Role role = roleService.getRoleById(id);
        modelMap.addAttribute("role", role);

        return "editRole";
    }
    @PostMapping("editRole")
    public String updateRole(@ModelAttribute("role") Role role) {
        roleService.update(role);
        return "redirect:/admin";
    }
} // public class AdminRoleController {
