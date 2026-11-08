package com.devsuperior.dscatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCatalogCardDTO {

    private Long id;
    private String imgUrl;
    private String name;
    private Double price;
}
