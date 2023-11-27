package com.springapps.jpaexamples.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
        // indic jpa ca aceasta este o clasa de service in care voi crea
// logica de business a aplicatiei
public class ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;
    //injectez been - ul de productCategoryRepository prin constructor
    //si ma folosesc de adnotarea @autowired

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }
    //Cream o categorie
    // de exmplu categoria "watches", cu descrierea "best watches"
    //categoria "cloth" cu descrierea "man"
    //categoria "devices" cu descrierea "electrical"
    public ProductCategory addProductCategory (ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
    //Vedem lista cu toate categoriile de produse
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }


    //Editam o categorie




}
