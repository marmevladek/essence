package com.project.essence.controller;

import com.project.essence.model.Manufacturer;
import com.project.essence.model.Product;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final UserService userService;

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("manufacturer", product.getManufacturer());
        return "product-info";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/product/add")
    public String newProduct(Model model, Principal principal) {
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "add-product";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin/product/add")
    public String addProduct(Product product,
                             @RequestParam("manufacturer") Manufacturer manufacturer,
                             @RequestParam("file1") MultipartFile file1,
                             @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3) throws IOException {
        productService.addProduct(product, manufacturer, file1, file2, file3);
        return "redirect:/admin";
    }




}
