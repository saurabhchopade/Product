package com.saurabh.ecommerce.product.repo;

import com.saurabh.ecommerce.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
