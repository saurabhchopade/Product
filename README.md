# eCommerce Product Controller

This repository contains the code for a RESTful API controller responsible for handling product-related operations in an
eCommerce application.

## Overview

The `ProductController` class provides endpoints for performing CRUD operations on product entities. It is built using
Spring Boot framework.

## Endpoints

### Get Product by ID

- **URL:** `/products/{id}`
- **Method:** GET
- **Description:** Retrieves a product by its ID.
- **Request Parameters:**
    - `{id}`: ID of the product to retrieve.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON representation of the product.

### Get All Products

- **URL:** `/products/getAllProducts`
- **Method:** GET
- **Description:** Retrieves a list of all products.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON array containing all products.

### Create Product

- **URL:** `/products/`
- **Method:** POST
- **Description:** Creates a new product.
- **Request Body:** JSON representation of the product.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON representation of the created product.

### Update Product

- **URL:** `/products/{id}`
- **Method:** PUT
- **Description:** Updates an existing product.
- **Request Parameters:**
    - `{id}`: ID of the product to update.
- **Request Body:** JSON representation of the updated product.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON representation of the updated product.

### Delete Product

- **URL:** `/products/{id}`
- **Method:** DELETE
- **Description:** Deletes a product by its ID.
- **Request Parameters:**
    - `{id}`: ID of the product to delete.
- **Response:**
    - Status Code: 200 OK
    - Body: JSON representation of the deleted product.

## Usage

To use this controller, integrate it into your Spring Boot application and configure the necessary dependencies. Ensure
that the `ProductService` is properly implemented to handle business logic related to products.

## Dependencies

- Spring Boot
- Spring Web
- Other dependencies as required by your application

## DevOps Integration

- **Add Loki Prometheus and Graphana Inegration and redis exporter  from redis which collect logs:**
  - Run prometheus: docker run --name prometheus -d -p 9090:9090 -v C:/Users/Wissen/Documents/Projects/product/product/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/Prometheus
  - Run loki:docker run -d --name loki -p 3100:3100 grafana/loki:latest
  - Run Grafana: docker run -d -p 3000:3000 --name=grafana grafana/grafana
  - Redis exporter docker run -d --name redis_exporter -p 9121:9121 oliver006/redis_exporter --redis.addr=redis://host.docker.internal:6379








