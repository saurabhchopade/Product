package com.saurabh.ecommerce.product.inheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_ta")
@Data
public class TA extends User{
    private int noOfSessions;
    private double rating;

}
