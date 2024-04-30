package com.saurabh.ecommerce.product.dto;


import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String title;
    private double price;
    private String desc;
    private String image;
    private String category;
}
