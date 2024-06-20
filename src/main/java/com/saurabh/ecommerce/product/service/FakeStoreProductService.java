package com.saurabh.ecommerce.product.service;

import com.saurabh.ecommerce.product.dto.FakeStoreResponseDto;
import com.saurabh.ecommerce.product.dto.ProductUpdateRequest;
import com.saurabh.ecommerce.product.exeptions.ProductNotFound;
import com.saurabh.ecommerce.product.models.Category;
import com.saurabh.ecommerce.product.models.Product;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("FakeStoreProductService")
@Data

public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product ProductGetById(long id) throws ProductNotFound {


        Product p = (Product) redisTemplate.opsForHash().get("PRODUCTS1", "PRODUCT_" + id);

        if (p != null) {
            return p;
        }
        FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreResponseDto.class);

        if (fdto == null) {
            throw new ProductNotFound("Product not found!");
        }

        p = DtoConversion(fdto);
        redisTemplate.opsForHash().put("PRODUCTS1", "PRODUCT_" + id, p);

        return p;

    }

    @Override
    public List<Product> getAllProduct() {

        ResponseEntity<List<FakeStoreResponseDto>> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeStoreResponseDto>>() {
                }
        );

        List<FakeStoreResponseDto> fdto = responseEntity.getBody();

        if (fdto == null) {
            return null;
        }

        List<Product> p = new ArrayList<>();
        for (FakeStoreResponseDto dto : fdto) {
            p.add(DtoConversion(dto));
        }
        return p;
    }

    public Product DtoConversion(FakeStoreResponseDto fdto) {
        Product p = new Product();
        p.setId(fdto.getId());
        p.setDescription(fdto.getDesc());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());
        Category c = new Category();
        c.setCategory(fdto.getCategory());
        p.setCategory(c);
        return p;
    }

    public ProductUpdateRequest createRequestBody(Product product) {
        ProductUpdateRequest requestBody = new ProductUpdateRequest();
        requestBody.setTitle(product.getTitle());
        requestBody.setPrice(product.getPrice());
        requestBody.setCategory(product.getDescription());
        requestBody.setImage(product.getImage());
        requestBody.setCategory(product.getCategory().getCategory());
        return requestBody;
    }

    @Override
    public Product updateProduct(Product product, long id) {
        // Create RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Set up the HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request body as an object
        ProductUpdateRequest requestBody = createRequestBody(product);

        // Create the HttpEntity with headers and body
        HttpEntity<ProductUpdateRequest> requestEntity = new HttpEntity<>(requestBody, headers);

        // Specify the URL of the product to update
        String productUrl = "https://fakestoreapi.com/products/" + id; // Update with the correct product ID

        // Make the PUT request
        restTemplate.exchange(productUrl, HttpMethod.PUT, requestEntity, String.class);

        FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreResponseDto.class);

        if (fdto == null) {
            return null;
        }

        return DtoConversion(fdto);

    }

    @Override
    public Product deleteProduct(long id) {

        ResponseEntity<FakeStoreResponseDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<FakeStoreResponseDto>() {
                }
        );

        FakeStoreResponseDto fdto = responseEntity.getBody();
        if (fdto == null) {
            System.err.println("Response body is null.");
            return null;
        }
        return DtoConversion(fdto);
    }

    @Override
    public Product createProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();

        // Set up the HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request body as an object
        ProductUpdateRequest requestBody = createRequestBody(product);

        // Create the HttpEntity with headers and body
        HttpEntity<ProductUpdateRequest> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the PUT request
        ResponseEntity<FakeStoreResponseDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/",
                HttpMethod.POST, requestEntity, new ParameterizedTypeReference<FakeStoreResponseDto>() {
                });

        FakeStoreResponseDto fdto = responseEntity.getBody();
        if (fdto == null) {
            System.err.println("Response body is null.");
            return null;
        }

        return DtoConversion(fdto);

    }


}
