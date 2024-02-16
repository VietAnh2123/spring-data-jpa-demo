package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product object
        Product product = new Product();
        product.setName("product 02");
        product.setDescription("second product description");
        product.setSku("110AB");
        product.setPrice(new BigDecimal(200));
        product.setActive(false);
        product.setImageUrl("img2.png");
        //save object into database
        Product savedObj = productRepository.save(product);
        //display product info
        System.out.println(savedObj.getId());
        System.out.println(savedObj.toString());
    }

    @Test
    void updateMethodUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        //update retrieved entity information
        product.setName("product01 updated");
        product.setActive(false);
        product.setDescription("first updated product description");
        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        //get entity
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){
        Product product3 = new Product(3L,"600CC", "product06", "sixth product description", new BigDecimal(600), true, "img6.png", LocalDateTime.now(), LocalDateTime.now());
        Product product4 = new Product(4L,"700CD", "product07", "seventh product description", new BigDecimal(700), true, "img7.png", LocalDateTime.now(), LocalDateTime.now());
        Product product5 = new Product(5L,"800BD", "product08", "eighth product description", new BigDecimal(80), true, "img8.png", LocalDateTime.now(), LocalDateTime.now());

//        ArrayList<Product> list = new ArrayList<>();
//        list.add(product3);
//        list.add(product4);
//        list.add(product5);
//
//        Iterator<Product> iterator = list.iterator();
//        while (iterator.hasNext()){
//            productRepository.saveAll(list);
//        }

        productRepository.saveAll(List.of(product3, product4, product5));
    }

    @Test
    void findAllMethod(){

        List<Product> list = productRepository.findAll();

        list.forEach((product)->{
            System.out.println(product.getId() + " " + product.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }

    @Test
    void countMethod(){
        Long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        Long id = 12L;
        if(productRepository.existsById(id)){
            System.out.println("ID Existed!");
        }else{
            System.out.println("ID does not exist!");
        }
    }

}