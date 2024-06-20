package com.saurabh.ecommerce.product.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String email;
    private List<Roles> roles;
}
