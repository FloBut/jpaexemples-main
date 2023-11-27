package com.springapps.jpaexamples.shop;

import jakarta.persistence.*;
// crez un tabel in care am mai multe categorii de produse
// si un id pentru fiecare categorie

@Entity// indic jpa ului ca voi crea un tabel
@Table(name = "shop")// indic numele tabelului
public class ProductCategory {
    @Id// fiecare categorie are un id unic in tabel
    @GeneratedValue// genreaza automat valoarea fiecarui id din tabel
    @Column(name = "productCategory_id") // coloana in care voi pune valoarea id ului
    private long productCategoryId;// numele coloanei

    @Column(name = "productCategory_type")
    private String productCategoryType;
    @Column(name = "description")
    private String description;
    //creez mai intai constructorul gol, practic cu ajutorul lui imi voi crea un tabel gol
    public ProductCategory() {
    }

    public ProductCategory(String productCategoryType, String description) {
        this.productCategoryType = productCategoryType;
        this.description = description;
    }

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }


    public String getProductCategoryType() {
        return productCategoryType;
    }

    public void setProductCategoryType(String productCategoryType) {
        this.productCategoryType = productCategoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

