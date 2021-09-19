package com.microservice.product.repositories;

import com.microservice.product.models.ProductInfo;

import java.util.List;

public interface ProductMockRepository {

    public List<ProductInfo> createMock();

    public ProductInfo getProductInfo(Long productID);

}
