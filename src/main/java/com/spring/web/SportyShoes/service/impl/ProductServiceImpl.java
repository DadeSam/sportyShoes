package com.spring.web.SportyShoes.service.impl;

import com.spring.web.SportyShoes.service.ProductService;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.SportyShoes.entity.Product;
import com.spring.web.SportyShoes.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService  {
	
	private ProductRepository productRepository;
	
	  public ProductServiceImpl (ProductRepository productRepository) { 
		  super();
		  this.productRepository = productRepository; 
	 }	 

	@Override
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Integer product_id) {
		return productRepository.findById(product_id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
	
	@Override
	public void deleteProductById(Integer product_id) {
		productRepository.deleteById(product_id);
	}
}
