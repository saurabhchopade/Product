package com.saurabh.ecommerce.product.repo;

import com.saurabh.ecommerce.product.models.Product;
import com.saurabh.ecommerce.product.projection.ProductWithTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface represents a repository for managing Product entities.
 * It extends the JpaRepository interface and provides additional methods for querying products.
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String title);

    List<Product> findByTitleAndDescription(String title, String description);

    @Override
    Product save(Product product);



    @Query("SELECT p.title as title FROM Product p WHERE p.id = :id")
    ProductWithTitle random(@Param("id") Long id);


    @Query(value = "SELECT title FROM Product WHERE id = :id", nativeQuery = true)
    ProductWithTitle getProductTitleByIdNative(@Param("id") Long id);

}
