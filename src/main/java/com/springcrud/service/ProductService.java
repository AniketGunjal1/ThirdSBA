package com.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springcrud.custom.exception.BusinessException;
import com.springcrud.entity.Product;
import com.springcrud.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		try {
			if(product.getName().isEmpty() || product.getName().length()==0) {
				throw new BusinessException("606","Please Enter Valid Name ");
			}
			return repository.save(product);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602","Null Value"+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603","Something Went Wrong in service layer"+e.getMessage());
		}
	}
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	
	public Product getProductById(int id){
		
		try {
			return repository.findById(id).orElse(null);
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("604","Null Value"+e.getMessage());
		}catch (java.util.NoSuchElementException e) {
			throw new BusinessException("605","Record Dosent Exist In Database."+e.getMessage());
		}
		
	}
	public Product getProductByName(String name){
		try {
			return repository.findByName(name);
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("607","Null Value"+e.getMessage());
		}catch (java.util.NoSuchElementException e) {
			throw new BusinessException("608","Record Dosent Exist In Database."+e.getMessage());
		}
		
	}
	
	public String deleteProduct(int id) {
		try {
			repository.deleteById(id);
			return "Product Deleted " +id;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("609","Null Value"+e.getMessage());
		}catch (java.util.NoSuchElementException e) {
			throw new BusinessException("703","Record Dosent Exist In Database."+e.getMessage());
		}
		
		
	}
	
	
	public Product updateProduct(Product product) {
		try {
			Product existingProduct =repository.findById(product.getId()).orElse(product);
			existingProduct.setName(product.getName());
			return repository.save(existingProduct);
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("701","Null Value"+e.getMessage());
		}catch (java.util.NoSuchElementException e) {
			throw new BusinessException("702","Record Dosent Exist In Database."+e.getMessage());
		}
		
		
	
	}
	

	
	

}
