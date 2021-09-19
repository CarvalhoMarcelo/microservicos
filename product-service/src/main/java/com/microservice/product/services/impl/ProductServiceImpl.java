package com.microservice.product.services.impl;

import com.microservice.product.models.Inventory;
import com.microservice.product.models.Price;
import com.microservice.product.models.Product;
import com.microservice.product.models.ProductInfo;
import com.microservice.product.repositories.ProductMockRepository;
import com.microservice.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ProductMockRepository productMockRepository;

    @Override
    public Product getProductInfo(Long id) {

        return getProduct(id);

    }

    private Product getProduct(Long id)  {

        try{
            ProductInfo productInfo = productMockRepository.getProductInfo(id);

            Product product = new Product();
            product.setProductID(productInfo.getProductID());
            product.setProductName(productInfo.getProductName());
            product.setProductDescr(productInfo.getProductDescr());
            product.setProductPrice(Objects.requireNonNull(getPrice(id),"Error retrieving Price!").getDiscountedPrice());
            product.setProductStock(Objects.requireNonNull(getInventory(id), "Error retrieving Inventory!").getInStock());

            return product;

        } catch (NullPointerException e){
            Logger.getLogger(e.getMessage());
            throw new NullPointerException(e.getMessage());
        }
    }


    private Price getPrice(Long id) {

        try {
            return restTemplate.getForObject("http://localhost:8002/price/"+id, Price.class);
        } catch (Exception e){
            Logger.getLogger(e.getMessage());
            return null;
        }

    }

    private Inventory getInventory(Long id){

        try {
            return restTemplate.getForObject("http://localhost:8003/inventory/"+id, Inventory.class);
        } catch (Exception e){
            Logger.getLogger(e.getMessage());
            return null;
        }

    }


}
