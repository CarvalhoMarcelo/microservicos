package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/product/details/{productID}")
	public Product getProductDetails(@PathVariable Long productID) {
		
		ProductInfo productInfo = getProductInfo(productID);
		
		Price price = restTemplate.getForObject("http://localhost:8002/price/"+productID, Price.class);
		Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/"+productID, Inventory.class);
		
		
		
		return new Product(productInfo.getProductID(), productInfo.getProductName(), productInfo.getProductDescr(), 
				 price.getDiscountedPrice(), inventory.getInStock());
		
	}
	
	public ProductInfo getProductInfo(Long productID) {
		
		getProductList();
		
		for(ProductInfo product : productList) {
			if(productID.equals(product.getProductID()))
				return product;
		}
		
		return null;
		
	}
	
	
	public void getProductList() {
		
		productList.add(new ProductInfo(101L, "iPhone", "iPhone is expensive!"));
		productList.add(new ProductInfo(102L, "iBook", "My book is expensive!"));
		productList.add(new ProductInfo(103L, "iWatch", "The watch is expensive!"));
		
		
		
		
	}
	

}
