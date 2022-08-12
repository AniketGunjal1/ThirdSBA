package com.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcrud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

		Product findByName(String name);
	
}
	
