package com.saurabh.ecommerce.product.repo;

import com.saurabh.ecommerce.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
