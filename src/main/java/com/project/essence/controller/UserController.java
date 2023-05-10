package com.project.essence.controller;

import com.project.essence.model.User;
import com.project.essence.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user, false)) {
            model.addAttribute("errorMessage", "Пользователь с email " + user.getEmail() + "уже существует!");
            return "registration";
        }
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "login";
    }


    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "profile";
    }


}
