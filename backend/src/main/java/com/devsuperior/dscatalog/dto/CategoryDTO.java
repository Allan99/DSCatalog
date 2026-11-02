package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CategoryDTO {

    private Long id;
    @NotBlank(message = "Field required.")
    @Size(min = 10, message = "Field has to contain at least 10 characters.")
    private String name;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }
}
