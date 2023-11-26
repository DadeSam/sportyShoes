package com.spring.web.SportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.web.SportyShoes.repository.CategoryRepository;

@Controller
public class CategoryController {

	private final CategoryRepository categoryRepository;
	
	@Autowired
    public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	 
	  @GetMapping("/PurchaseReport")
	  public String viewPurchaseReportForm(Model model) {
	        model.addAttribute("categories", categoryRepository.findAll());
	        return "PurchaseReport";
	    }

}
