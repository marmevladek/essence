package com.project.essence.controller;

import com.project.essence.model.Manufacturer;
import com.project.essence.model.User;
import com.project.essence.service.ManufacturerService;
import com.project.essence.service.ProductService;
import com.project.essence.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final ProductService productService;
    private final UserService userService;
    private final ManufacturerService manufacturerService;

    @GetMapping("/admin")
    public String admin(@RequestParam(name="nameOfProduct", required = false) String nameOfProduct, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "admin";
    }

    @GetMapping("/admin/createAdmin")
    public String newAdmin() {
        return "add-admin";
    }

    @PostMapping("/admin/createAdmin")
    public String createAdmin(User user, Model model) {
        if (!userService.createUser(user, true)) {
            model.addAttribute("errorMessage", "Пользователь с email " + user.getEmail() + "уже существует!");
            return "admin";
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/createManufacturer")
    public String newManufacturer() {
        return "add-manufacturer";
    }

    @PostMapping("/admin/createManufacturer")
    public String createManufacturer(Manufacturer manufacturer, Model model) {
        if (!manufacturerService.createManufacturer(manufacturer)) {
            model.addAttribute("errorMessage", "Производитель с именем " + manufacturer.getNameOfManufacturer() + "уже существует!");
            return "admin";
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/products")
    public String productsList(@RequestParam(name="nameOfProduct", required = false) String nameOfProduct, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("products", productService.listOfProduct(nameOfProduct));
        return "admin-products";
    }

    @GetMapping("/admin/users")
    public String usersList(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("users", userService.getAllUsers());
        return "admin-users";
    }

    @GetMapping("/admin/manufacturers")
    public String manufacturersList(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        return "admin-manufacturers";
    }

    @PostMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/manufacturer/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/user/ban/{id}")
    public String banUser(@PathVariable("id") Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }
}
