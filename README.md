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

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

