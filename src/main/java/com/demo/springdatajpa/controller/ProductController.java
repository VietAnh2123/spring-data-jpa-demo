package com.demo.springdatajpa.controller;

import com.demo.springdatajpa.entities.Product;
import com.demo.springdatajpa.services.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void saveProduct(Product product){
        productService.saveProduct(product);
    }
}
