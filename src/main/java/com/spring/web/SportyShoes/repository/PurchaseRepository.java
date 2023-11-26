package com.spring.web.SportyShoes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.web.SportyShoes.entity.Purchase;
//import com.spring.web.SportyShoes.entity.PurchaseItem;

@Repository
public interface PurchaseRepository extends JpaRepository <Purchase, Integer>{

	 List<Purchase> findAll(); 
	// List<Purchase> findByPurchaseItemsProductCategoryCategoryNameAndDate(String category, String date);
	//List<Purchase> findByPurchaseItemsProductCategoryCategoryNameAndDate(categoryName, String dateString);
	List<Purchase> findByPurchaseItemsProductCategoryCategoryNameAndDate(String categoryName, LocalDate parsedDate);

	List<Purchase> findByPurchaseItemsProductCategoryCategoryName(String category);

	List<Purchase> findByDate(LocalDate parsedDate);
}

