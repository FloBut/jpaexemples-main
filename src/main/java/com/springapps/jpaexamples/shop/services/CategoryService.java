package com.springapps.jpaexamples.shop.services;

import com.springapps.jpaexamples.shop.entities.Category;
import com.springapps.jpaexamples.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
        // indic jpa ca aceasta este o clasa de service in care voi crea
// logica de business a aplicatiei
public class CategoryService {
    private CategoryRepository categoryRepository;
    //injectez been - ul de productCategoryRepository prin constructor
    //si ma folosesc de adnotarea @autowired

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    //Cream o categorie
    // de exmplu categoria "watches", cu descrierea "best watches"
    //categoria "cloth" cu descrierea "man"
    //categoria "devices" cu descrierea "electrical"
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    //Vedem lista cu toate categoriile de produse
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    //Editam o categorie
    //la cetagoria




}
