package com.saurabh.ecommerce.product.dto;

import lombok.Data;


@Data
public class FakeStoreResponseDto {
    private long id;
    private String title;
    private double price;
    private String desc;
    private String image;
    private String category;

}
