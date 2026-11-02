package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name,
                      String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public ProductDTO(Product product, Set<Category> categories){
        this(product);
        this.categories = categories
                .stream()
                .map(c -> new CategoryDTO(c))
                .toList();
    }

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        date = product.getDate();
    }
}
