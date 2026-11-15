package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Product;
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

    public ProductCatalogCardDTO(Product product){
        id = product.getId();
        imgUrl = product.getImgUrl();
        name = product.getName();
        price = product.getPrice();
    }
}
