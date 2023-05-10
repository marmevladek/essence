package com.project.essence.controller;

import com.project.essence.repository.ImageRepository;
import com.project.essence.service.ProductService;
import com.project.essence.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/")
    public String index(@RequestParam(name="nameOfProduct", required = false) String nameOfProduct, Model model, Principal principal) {
        model.addAttribute("products", productService.listOfProduct(nameOfProduct));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "main";
    }
}
