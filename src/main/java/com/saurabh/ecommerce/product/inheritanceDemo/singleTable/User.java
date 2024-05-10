package com.saurabh.ecommerce.product.inheritanceDemo.singleTable;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "ST_user")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "User_type",
        discriminatorType = DiscriminatorType.INTEGER
)

@DiscriminatorValue(value = "0")
public class User {

    @Id
    private long ID;
    private String Name;
    private String email;
    private String password;
}
