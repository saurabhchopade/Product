package com.saurabh.ecommerce.product.inheritanceDemo.joinedTable;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_instructor")
@Data
public class Instructor extends User {
    private String specialization;
}
