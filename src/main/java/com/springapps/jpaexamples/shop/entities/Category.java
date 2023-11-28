package com.springapps.jpaexamples.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
// crez un tabel in care am mai multe categorii de produse
// si un id pentru fiecare categorie

@Entity// indic jpa ului ca voi crea un tabel
// indic numele tabelului
public class Category {
    @Id// fiecare categorie are un id unic in tabel
    @GeneratedValue(strategy=GenerationType.IDENTITY)// genereaza automat valoarea fiecarui id din tabel
   // coloana in care voi pune valoarea id ului
    private Long id;// numele coloanei

    @Column
    private String name;
    @Column
    private String description;
    //creez mai intai constructorul gol, practic cu ajutorul lui imi voi crea un tabel gol
   //categoria are o lista de produse
    @OneToMany(mappedBy = "category")
    @JsonManagedReference("category-product")
    List<Product> productList;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long productCategoryId) {
        this.id = productCategoryId;
    }


    public String getName() {

        return name;
    }

    public void setName(String productCategoryType) {

        this.name = productCategoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + id +
                ", productCategoryType='" + name + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}

