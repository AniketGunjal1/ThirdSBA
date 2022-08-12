package com.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.custom.exception.BusinessException;
import com.springcrud.custom.exception.ControllerException;
import com.springcrud.entity.Product;
import com.springcrud.service.ProductService;

/**
 * @author mindc1july10
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	
	public Product addProduct(@RequestBody Product product) {
		
		return service.saveProduct(product);
		
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
		
	}
	
	@GetMapping("/Products")
	public List<Product> findAllProducts(){
		
		return service.getProducts();
		
	}
	
	
	@GetMapping("/Products/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
		
	}
	
	@GetMapping("/Product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
		
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		
			return service.deleteProduct(id);
			
		}
		
	
	
	
}
