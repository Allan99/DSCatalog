package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;
    private String imgUrl;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Setter(AccessLevel.NONE)
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, Double price,
                   Instant date, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.imgUrl = imgUrl;
    }
}
