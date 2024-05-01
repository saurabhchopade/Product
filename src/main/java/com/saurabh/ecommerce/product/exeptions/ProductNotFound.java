package com.saurabh.ecommerce.product.exeptions;

public class ProductNotFound extends Exception {
    public ProductNotFound(String message) {
        super(message);
    }
}
