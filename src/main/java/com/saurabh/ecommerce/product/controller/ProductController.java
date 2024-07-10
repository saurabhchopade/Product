package com.saurabh.ecommerce.product.controller;


import com.saurabh.ecommerce.product.common.AuthCommon;
import com.saurabh.ecommerce.product.models.Product;
import com.saurabh.ecommerce.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final AuthCommon authCommon;
    private final ProductService productService;
    final static Logger logger = LoggerFactory.getLogger(ProductController.class);
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService, AuthCommon authCommon) {
        this.productService = productService;
        this.authCommon = authCommon;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id, @RequestHeader("Auth") String auth) throws Exception {
        logger.warn("Just Checking");
        logger.info("Just Info");
//        UserDto user = authCommon.validate(auth);

//        if (user != null) {
//            if (user != null) {
//                for(Roles r : user.getRoles()){
//                    if (r.getRole() == "ADMIN"){
        Product p = productService.ProductGetById(id); // dependency..

        return new ResponseEntity<>(p, HttpStatus.OK);
//                    }
//                }
//            }
//        }
//        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getListOfProduct() {
        System.out.println("========");
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
