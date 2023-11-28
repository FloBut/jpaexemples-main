package com.springapps.jpaexamples.shop.dtos;

public class ProductRequestDTO {


    private Double price;
    private String name;
    private Long categoryId;

    public ProductRequestDTO(Double price, String name, Long categoryId) {
        this.price = price;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
