package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Product;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class ProductDTO {

    private Long id;
    private String name;
    private Instant date;
    private String description;
    private Double price;
    private String imgUrl;

    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Long id, String name, Instant date,
                      String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        date = product.getDate();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        categories = product.getCategories()
                .stream()
                .map(c -> new CategoryDTO(c))
                .collect(Collectors.toSet());
    }
}
