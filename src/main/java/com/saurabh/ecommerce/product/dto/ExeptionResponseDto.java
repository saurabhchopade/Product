package com.saurabh.ecommerce.product.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ExeptionResponseDto {
    private String message;
    private HttpStatus status;
}
