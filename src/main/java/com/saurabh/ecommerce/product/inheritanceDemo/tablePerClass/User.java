package com.saurabh.ecommerce.product.inheritanceDemo.tablePerClass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name = "TPC_user")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    private Long ID;
    private String Name;
    private String email;
    private String password;
}
