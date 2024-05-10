package com.saurabh.ecommerce.product.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity(name = "ST_mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {

    private double mentorRating;
}
