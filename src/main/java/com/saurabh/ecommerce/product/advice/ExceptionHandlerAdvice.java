package com.saurabh.ecommerce.product.advice;


import com.saurabh.ecommerce.product.dto.ExceptionResponseDto;
import com.saurabh.ecommerce.product.exeptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionResponseDto> handleProductNotFoundException() {
        ExceptionResponseDto dto = new ExceptionResponseDto();
        dto.setMessage("Product Not Found");
        dto.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGlobalException(Exception ex) {
        ExceptionResponseDto dto = new ExceptionResponseDto();
        dto.setMessage("Internal Server Error: " + ex.getMessage());
        dto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
