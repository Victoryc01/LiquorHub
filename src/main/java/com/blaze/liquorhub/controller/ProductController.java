package com.blaze.liquorhub.controller;

import com.blaze.liquorhub.model.Product;
import com.blaze.liquorhub.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        System.out.println("listProduct Called");
        // Retrieve all products from the service
        List<Product> products = productService.getAllProduct();

        // Add the products to the model for rendering in the HTML template
        model.addAttribute("productsRequest", products);

        // Return the HTML template to display the products
        return "product_list"; // Assuming you have a Thymeleaf template named "product_list.html"
    }

    @PostMapping("/products")
    public String processProductForm() {
        return "redirect:/products";
    }
}
