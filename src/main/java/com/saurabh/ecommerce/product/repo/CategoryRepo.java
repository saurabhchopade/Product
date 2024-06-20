package com.saurabh.ecommerce.product.repo;

import com.saurabh.ecommerce.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);

    Optional<Category> findById(Long id);
}
