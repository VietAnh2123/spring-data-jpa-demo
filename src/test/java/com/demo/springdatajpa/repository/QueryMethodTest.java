package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product06");

        if (product != null){
            System.out.println(product.toString());
        }else{
            System.out.println("Product name does not exist!");
        }
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> list = productRepository.findByNameOrDescription("product07", "sixth product description");

        list.forEach((product) ->{
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> list = productRepository.findByNameAndDescription("product08", "eighth product description");

        list.forEach((product)->{
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> list = productRepository.findByNameLike("product08");

        list.forEach((product)->{
            System.out.println(product.toString());
        });
    }

    @Test
    void findbyNameContainingMethod(){
        List<Product> list = productRepository.findByNameContaining("product");

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product08");
        System.out.println(product.toString());
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> list = productRepository.findByPriceLessThan(new BigDecimal(400));

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> list = productRepository.findByPriceGreaterThan(new BigDecimal(500));

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameContainingOrderByPriceDescMethod(){
        List<Product> list = productRepository.findByNameContainingOrderByPriceDesc("product");

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> list = productRepository.findByPriceBetween(new BigDecimal(300), new BigDecimal(800));

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2024,01,28,16,20, 33);
        LocalDateTime endDate = LocalDateTime.of(2024,01,28,16,20,35);

        List<Product> list = productRepository.findByDateCreatedBetween(startDate,endDate);

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> list = productRepository.findByNameIn(List.of("product06", "product07"));

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findTop2ByNameContaining(){
        List<Product> list = productRepository.findTop2ByNameContaining("product");

        list.forEach(product -> {
            System.out.println(product.toString());
        });
    }
}
