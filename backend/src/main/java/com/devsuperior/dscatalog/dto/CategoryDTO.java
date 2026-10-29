package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }
}
