package com.petcom.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcom.petshop.dto.ProductDto;
import com.petcom.petshop.entity.Product;
import com.petcom.petshop.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService proService;
	
	@PostMapping("post-product")
	public Product saveProduct(@RequestBody ProductDto productDetails) {
		return proService.saveProduct(productDetails);
	}
	
	@GetMapping("get-product/{product_id}")
	public Product getProduct(@PathVariable long product_id) {
		return proService.getProductByID(product_id);
	}
	
	@GetMapping("get-all-products")
	public List<Product> getAllProducts(){
		return proService.getAllProducts();
	}
	
	@PostMapping("save-products")
	public List<Product>saveProducts(@RequestBody List<ProductDto> productDetails){
		return proService.saveAllProducts(productDetails);
	}
	
	@DeleteMapping("delete-product/{product_id}")
	public String deleteProduct(@PathVariable long product_id) {
		proService.deleteProductById(product_id);
		return "Product Deleted Successfully";
	}
	
	@PutMapping("update-product/{product_id}")
	public Product updateProduct(@RequestBody ProductDto productDto , @PathVariable long product_id) {
		return proService.updateProduct(productDto,product_id);
	}
	
	
}
