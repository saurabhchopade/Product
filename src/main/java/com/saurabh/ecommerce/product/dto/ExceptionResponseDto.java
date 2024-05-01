package com.saurabh.ecommerce.product.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ExceptionResponseDto {
    private String message;
    private HttpStatus status;
}
