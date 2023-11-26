package com.spring.web.SportyShoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.web.SportyShoes.entity.Category;
import com.spring.web.SportyShoes.entity.Product;
import com.spring.web.SportyShoes.repository.CategoryRepository;
import com.spring.web.SportyShoes.service.CategoryService;
import com.spring.web.SportyShoes.service.ProductService;
import com.spring.web.SportyShoes.service.impl.CategoryServiceImpl;

import java.util.List;

@Controller
public class ProductController {
	
	private ProductService productService;
	private CategoryService categoryService;
	
	public ProductController (ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/ViewProduct")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "ViewProduct";		
	}
	
	@GetMapping("/AddProduct")
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		 List<Category> categories = categoryService.getAllCategories();
	        model.addAttribute("categories", categories);
		return "AddProduct";	
	}
	
	@PostMapping ("/ViewProduct")
	public String saveProduct(@ModelAttribute ("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/ViewProduct";		
	}
	
	@GetMapping("/ViewProduct/edit/{product_id}")
	public String editProduct(@PathVariable Integer product_id, Model model) {
	    Product product = productService.getProductById(product_id);
	    List<Category> categories = categoryService.getAllCategories();

	    model.addAttribute("product", product);
	    model.addAttribute("categories", categories);

	    return "UpdateProduct";
	}

	
	
	  @PostMapping("/ViewProduct/{product_id}") 
	  public String UpdateProduct(@PathVariable Integer product_id,
	  @ModelAttribute("product") Product product, 
	  @ModelAttribute("category") Category category,
	  Model model) {
		  
		//get product from database by Id
		Product existingProduct = productService.getProductById(product_id);
		//existingProduct.setProduct_id(product_id);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());		
		//save updated product object
		productService.updateProduct(existingProduct);
		return "redirect:/ViewProduct";		
	}
	  
	  @GetMapping("/ViewProduct/delete/{product_id}")
	  public String deleteProduct(@PathVariable Integer product_id) {
		  productService.deleteProductById(product_id);
		return "redirect:/ViewProduct";  
	  }
	  
	  @GetMapping("/ManageProduct")
	  public String manageProduct(){
		  return "ManageProduct";
	  }	  	
	
}
 