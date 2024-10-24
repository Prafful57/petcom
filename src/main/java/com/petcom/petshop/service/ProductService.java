package com.petcom.petshop.service;

import java.util.List;

import com.petcom.petshop.dto.ProductDto;
import com.petcom.petshop.entity.Product;

public interface ProductService {

	Product saveProduct(ProductDto productDetails);

	Product getProductByID(long product_id);

	List<Product> getAllProducts();

	List<Product> saveAllProducts(List<ProductDto> productDetails);

	void deleteProductById(long product_id);

	Product updateProduct(ProductDto productDto, long product_id);

}
