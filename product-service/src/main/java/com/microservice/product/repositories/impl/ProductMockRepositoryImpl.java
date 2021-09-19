package com.microservice.product.repositories.impl;

import com.microservice.product.models.ProductInfo;
import com.microservice.product.repositories.ProductMockRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductMockRepositoryImpl implements ProductMockRepository {


    @Override
    public List<ProductInfo> createMock() {

        List<ProductInfo> productList = new ArrayList<ProductInfo>();

        productList.add(new ProductInfo(101L, "iPhone", "iPhone is expensive!"));
        productList.add(new ProductInfo(102L, "iBook", "My book is expensive!"));
        productList.add(new ProductInfo(103L, "iWatch", "The watch is expensive!"));

        return productList;
    }

    @Override
    public ProductInfo getProductInfo(Long productID) {

        List<ProductInfo> productList = createMock();

        for(ProductInfo product : productList) {
            if(productID.equals(product.getProductID()))
                return product;
        }

        return null;

    }



}
