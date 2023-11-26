package com.spring.web.SportyShoes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.SportyShoes.entity.Category;
import com.spring.web.SportyShoes.repository.CategoryRepository;
import com.spring.web.SportyShoes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;
	
	  public CategoryServiceImpl (CategoryRepository categoryRepository) { 
		  super();
		  this.categoryRepository = categoryRepository; 
	 }	 
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
}
