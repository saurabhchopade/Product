package com.saurabh.ecommerce.product.inheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "TPC_mentor")
@Data
public class Mentor extends User {

    private double mentorRating;
}
