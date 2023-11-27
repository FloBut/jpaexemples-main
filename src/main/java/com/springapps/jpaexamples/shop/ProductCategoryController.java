package com.springapps.jpaexamples.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
//este clasa in care voi face cererile
// dinspre server si catre server prin intermediul url -ului
public class ProductCategoryController {
    ProductCategoryService productCategoryService;
@Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }
    @PostMapping
    //are rolul de a trimite date pentru a fi procesate catre o resursa specificata
    //datele sunt trimise in corpul solicitarii adica in cazul nostru in postman pun un order
    // prin body -> raw pun detaliile comenzii
    public ResponseEntity <ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory newProductCategory = productCategoryService.addProductCategory(productCategory);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productCategory);
    }

}
