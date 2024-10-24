package com.petcom.petshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	
	private String name;
	private String description;
	private float price;
	private int quantity;

}
