package com.saurabh.ecommerce.product.service;

import com.saurabh.ecommerce.product.exeptions.ProductNotFound;
import com.saurabh.ecommerce.product.models.Category;
import com.saurabh.ecommerce.product.models.Product;
import com.saurabh.ecommerce.product.repo.CategoryRepo;
import com.saurabh.ecommerce.product.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("SelfProductService")
public class SelfProductService implements ProductService {

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;


    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Product ProductGetById(long id) throws Exception {

        Optional<Product> productOptional = productRepo.findById(id);
        if (!productOptional.isPresent()) {
            throw new ProductNotFound("Product not found with id: " + id);
        }

        return productOptional.get();
    }

    @Override
    public Product updateProduct(Product product, long id) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {

        // save the category associated with the product first
        Category category = product.getCategory();
        if (category != null) {
            category = this.categoryRepo.save(category);
            product.setCategory(category);
        }

        Product product1 = productRepo.save(product);

        Optional<Category> category1 = categoryRepo.findById(product.getCategory().getId());
        if (category1.isPresent()) {
            product1.setCategory(category1.get());
        }
        return product1;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
