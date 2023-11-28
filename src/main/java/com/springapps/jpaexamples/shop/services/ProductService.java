package com.springapps.jpaexamples.shop.services;

import com.springapps.jpaexamples.orderapp.ResourceNotFoundException;
import com.springapps.jpaexamples.shop.dtos.ProductRequestDTO;
import com.springapps.jpaexamples.shop.entities.Category;
import com.springapps.jpaexamples.shop.entities.Product;
import com.springapps.jpaexamples.shop.repositories.CategoryRepository;
import com.springapps.jpaexamples.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

@Autowired
    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Product addProduct(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("category not found"));
        Product productToBeSaved = new Product();
        productToBeSaved.setName(productRequestDTO.getName());
        productToBeSaved.setPrice(productRequestDTO.getPrice());
        productToBeSaved.setCategory(category);
        return productRepository.save(productToBeSaved);
    }


}
