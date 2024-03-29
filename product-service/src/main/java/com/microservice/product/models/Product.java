package com.microservice.product.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Long productID;
	private String productName;
	private String productDescr;
	private Integer productPrice;
	private Boolean productStock;
	

}
