package com.saurabh.ecommerce.product;

import com.saurabh.ecommerce.product.projection.ProductWithTitle;
import com.saurabh.ecommerce.product.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {


    @Autowired
    public ProductRepo p;

//	@Autowired
//	CategoryRepo c;


    @Test
    @Transactional
    void random() {
        ProductWithTitle sql = p.getProductTitleByIdNative(1L);
        System.out.printf(sql.getTitle());
        System.out.println();
    }
}
