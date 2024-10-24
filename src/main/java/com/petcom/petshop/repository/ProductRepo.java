package com.petcom.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcom.petshop.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
