package com.saurabh.ecommerce.product.advice;


import com.saurabh.ecommerce.product.dto.ExeptionResponseDto;
import com.saurabh.ecommerce.product.exeptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionHandlerAdvice {


    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExeptionResponseDto> handleProductNotFoundException() {
        ExeptionResponseDto dto = new ExeptionResponseDto();
        dto.setMessage("Product Not Found");
        dto.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
