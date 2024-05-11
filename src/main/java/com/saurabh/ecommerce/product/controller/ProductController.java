package com.saurabh.ecommerce.product.controller;


import com.saurabh.ecommerce.product.models.Product;
import com.saurabh.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(productService.ProductGetById(id));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getListOfProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long id) {
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

}
