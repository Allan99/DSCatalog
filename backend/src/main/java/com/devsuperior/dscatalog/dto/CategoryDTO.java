package com.devsuperior.dscatalog.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CategoryDTO {

    private Long id;
    private String name;
}
