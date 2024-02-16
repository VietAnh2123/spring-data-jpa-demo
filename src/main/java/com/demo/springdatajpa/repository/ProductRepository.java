package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findByNameAndDescription(String name, String description);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameLike(String name);

    List<Product> findByNameContaining(String name); //SELECT FROM WHERE name like '%name%'

    Product findDistinctByName(String name);

    // <
    List<Product> findByPriceLessThan(BigDecimal price); // <= findByPriceLessThanEqual

    // >
    List<Product> findByPriceGreaterThan(BigDecimal price); // >= findByPriceGreaterThanEqual

    List<Product> findByNameContainingOrderByPriceDesc(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> name); // SELECT * FROM products WHERE name IN ('name1', 'name2')

    List<Product> findTop2ByNameContaining(String name);
}
