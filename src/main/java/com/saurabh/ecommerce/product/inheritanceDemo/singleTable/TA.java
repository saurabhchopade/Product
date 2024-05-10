package com.saurabh.ecommerce.product.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "ST_ta")
@Data
@DiscriminatorValue(value = "1")
public class TA extends User {
    private int noOfSessions;
    private double rating;

}
