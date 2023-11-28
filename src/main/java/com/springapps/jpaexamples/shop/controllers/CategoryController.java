package com.springapps.jpaexamples.shop.controllers;

import com.springapps.jpaexamples.shop.entities.Category;
import com.springapps.jpaexamples.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
//este clasa in care voi face cererile
// dinspre server si catre server prin intermediul url -ului
public class CategoryController {
    CategoryService categoryService;

    @Autowired
//injectez prin constructor been - ul
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    //are rolul de a trimite date pentru a fi procesate catre o resursa specificata
    //datele sunt trimise in corpul solicitarii adica in cazul nostru in postman pun un order
    // prin body -> raw pun detaliile comenzii
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category newCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> productCategories = categoryService.findAll();
        return ResponseEntity.ok(productCategories);
    }


}
