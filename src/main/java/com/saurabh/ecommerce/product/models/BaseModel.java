package com.saurabh.ecommerce.product.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;


@Data
@MappedSuperclass
public class BaseModel {

    @Id
    private long id;
    private Date createdAt;
    private Date updateAt;

}
