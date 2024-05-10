package com.saurabh.ecommerce.product.inheritanceDemo.singleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "ST_instructor")
@Data
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String specialization;
}
