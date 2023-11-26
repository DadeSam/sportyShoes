package com.spring.web.SportyShoes.service;

import java.util.List;

import com.spring.web.SportyShoes.entity.Product;

public interface ProductService {
	List <Product> getAllProducts();
	
	Product saveProduct(Product product);	
	Product getProductById(Integer product_id);
	Product updateProduct(Product product);
	void deleteProductById(Integer product_id);
}
  