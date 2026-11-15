package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CategoryDTO {

    private Long id;
    @NotBlank(message = "Field required.")
    @Size(min = 10, message = "Field has to contain at least 10 characters.")
    private String name;

    private Set<ProductCatalogCardDTO> products = new HashSet<>();

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }

    public CategoryDTO(Category category, Set<Product> products){
        id = category.getId();
        name = category.getName();
        this.products = products
                .stream()
                .map(p -> new ProductCatalogCardDTO(p))
                .collect(Collectors.toSet());
    }
}
