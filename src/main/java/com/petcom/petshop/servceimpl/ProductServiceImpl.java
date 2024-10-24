package com.petcom.petshop.servceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcom.petshop.dto.ProductDto;
import com.petcom.petshop.entity.Product;
import com.petcom.petshop.repository.ProductRepo;
import com.petcom.petshop.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo proRepo;
	
	@Override
	public Product saveProduct(ProductDto productDto) {
		if(productDto== null ) {
			throw new NullPointerException("Please enter product details");
		}
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		return proRepo.save(product);
	}

	@Override
	public Product getProductByID(long product_id) {
		Product product = proRepo.findById(product_id).orElseThrow(()->new NoSuchElementException("Product with product_id :"+product_id+ " is not present"));
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		return proRepo.findAll();
	}

	public List<Product> saveAllProducts(List<ProductDto> productDtos) {
		List<Product> products  = new ArrayList<>();
		for(ProductDto productDto : productDtos) {
			Product product = new Product();
			product.setName(productDto.getName());
			product.setDescription(productDto.getDescription());
			product.setPrice(productDto.getPrice());
			product.setQuantity(productDto.getQuantity());
			products.add(proRepo.save(product));
		}
		return products;
	}

	@Override
	public void deleteProductById(long product_id) {
		Product product = proRepo.findById(product_id).orElseThrow(()->new NoSuchElementException("Product with product_id :"+product_id+ " is not present"));
		proRepo.deleteById(product_id);
	}

	@Override
	public Product updateProduct(ProductDto productDto, long product_id) {
		// TODO Auto-generated method stub
		Product product = proRepo.findById(product_id).orElseThrow(()->new NoSuchElementException("Product with product_id :"+product_id+ " is not present"));
		if(productDto== null ) {
			throw new NullPointerException("Please enter product details");
		}
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		return proRepo.save(product);
	}


}
