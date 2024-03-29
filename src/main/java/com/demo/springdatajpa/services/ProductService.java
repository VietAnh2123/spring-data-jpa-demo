package com.demo.springdatajpa.services;

import com.demo.springdatajpa.entities.Product;
import com.demo.springdatajpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
