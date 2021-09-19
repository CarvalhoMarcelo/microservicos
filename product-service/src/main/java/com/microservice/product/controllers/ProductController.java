package com.microservice.product.controllers;

import java.util.ArrayList;
import java.util.List;

import com.microservice.product.models.ProductInfo;
import com.microservice.product.services.ProductService;
import com.microservice.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductService productService;

	@GetMapping("/product/details/{productID}")
	public Product getProductDetails(@PathVariable Long productID) {
		
		return productService.getProductInfo(productID);

	}
	
}
