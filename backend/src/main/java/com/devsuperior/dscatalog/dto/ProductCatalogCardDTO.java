package com.devsuperior.dscatalog.dto;

public class ProductCatalogCardDTO {

    private String imgUrl;
    private String name;
    private Double price;

    public ProductCatalogCardDTO(){

    }

    public ProductCatalogCardDTO(String imgUrl, String name, Double price) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
