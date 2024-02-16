package com.demo.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products",
        schema = "demo_jpa",
        uniqueConstraints = {
            @UniqueConstraint(name = "sku_unique",
            columnNames = "stock_keeping_unit")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false, length = 255)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp //get the current time from the JVM and then it will assign to this field
    private LocalDateTime dateCreated;

    @UpdateTimestamp // automatically provide timestamp for this field
    private LocalDateTime lastUpdated;
}
