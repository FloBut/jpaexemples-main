package com.springapps.jpaexamples.shop;

import com.springapps.jpaexamples.orderapp.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//creez o interfata care extinde interfata JpaRepository in care voi crea metodele de
//tip CRUD, precum si alte metode pentru clasa ProductCategory si ma folosesc de adnotarea@repository
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
