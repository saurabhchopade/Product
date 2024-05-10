package com.saurabh.ecommerce.product.inheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "TPC_ta")
@Data
public class TA extends User {
    private int noOfSessions;
    private double rating;

}
