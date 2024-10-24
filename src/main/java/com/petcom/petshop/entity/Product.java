package com.petcom.petshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="product")
public class Product {

//	Products
//	product_id (INT, PRIMARY KEY, AUTO_INCREMENT)
//	name (VARCHAR(100), NOT NULL)
//	description (TEXT)
//	price (DECIMAL(10, 2), NOT NULL)
//	stock_quantity (INT, NOT NULL)
//	category_id (INT, FOREIGN KEY references Categories(category_id))
//	created_at (DATETIME, DEFAULT CURRENT_TIMESTAMP)
//	updated_at (DATETIME, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	
	private String name;
	private String description;
	private float price;
	private int quantity;
	
	
}
