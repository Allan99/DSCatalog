package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Product;
import lombok.*;

import java.time.Instant;
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
    private String description;
    private Double price;
    private Instant date;
    private String imgUrl;

    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Long id, String name,
                      String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        date = product.getDate();
        categories = product.getCategories()
                .stream()
                .map(c -> new CategoryDTO(c))
                .collect(Collectors.toSet());
    }
}
