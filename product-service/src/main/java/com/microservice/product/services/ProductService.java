package com.microservice.product.services;


import com.microservice.product.models.Product;

public interface ProductService {

    public Product getProductInfo(Long id);
}
