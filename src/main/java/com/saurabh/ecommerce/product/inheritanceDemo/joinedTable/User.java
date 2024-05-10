package com.saurabh.ecommerce.product.inheritanceDemo.joinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name = "jt_user")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    private Long ID;
    private String Name;
    private String email;
    private String password;
}
