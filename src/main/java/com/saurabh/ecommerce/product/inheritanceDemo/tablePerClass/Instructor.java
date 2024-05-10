package com.saurabh.ecommerce.product.inheritanceDemo.tablePerClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "TPC_instructor")
@Data
public class Instructor extends User {
    private String specialization;
}
