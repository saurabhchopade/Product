package com.saurabh.ecommerce.product.service;

import com.saurabh.ecommerce.product.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product ProductGetById(long id);
    Product updateProduct(Product product, long id);
    Product deleteProduct(long id);
    Product createProduct(Product product);
    List<Product> getAllProduct();
}
