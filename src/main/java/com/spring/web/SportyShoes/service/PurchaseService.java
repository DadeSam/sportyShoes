package com.spring.web.SportyShoes.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.SportyShoes.entity.Product;
import com.spring.web.SportyShoes.entity.Category;
import com.spring.web.SportyShoes.entity.Purchase;
import com.spring.web.SportyShoes.entity.PurchaseItem;
import com.spring.web.SportyShoes.dto.PurchaseReportDTO;
import com.spring.web.SportyShoes.repository.ProductRepository;
import com.spring.web.SportyShoes.repository.PurchaseItemRepository;
import com.spring.web.SportyShoes.repository.CategoryRepository;
import com.spring.web.SportyShoes.repository.PurchaseRepository;

@Service
public class PurchaseService {
    
    private final PurchaseRepository purchaseRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    @Autowired
    public PurchaseService(
            PurchaseRepository purchaseRepository,
            PurchaseItemRepository purchaseItemRepository,
            ProductRepository productRepository,
            
            CategoryRepository categoryRepository
    ) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseItemRepository = purchaseItemRepository;
    }

    public List<PurchaseReportDTO> getPurchaseReports(String category, LocalDate parsedDate) {
        List<Purchase> purchases;

        if ("".equals(category) && parsedDate == null) {
            purchases = purchaseRepository.findAll(); // Retrieve all purchases
            System.out.println("printing all purchases" + purchases);
        } else if (parsedDate == null) {
            purchases = purchaseRepository.findByPurchaseItemsProductCategoryCategoryName(category); // Filter by category name
            System.out.println("purchase by category" + purchases);
        } else if ("".equals(category)) {
            purchases = purchaseRepository.findByDate(parsedDate); // Filter by date
            System.out.println("purchase by date" + purchases);
        } else {
            purchases = purchaseRepository.findByPurchaseItemsProductCategoryCategoryNameAndDate(category, parsedDate); // Filter by both category name and date
            System.out.println("purchase by category and date" + purchases);
        }

        // Rest of the code...
    


        List<PurchaseReportDTO> purchaseReports = new ArrayList<>();
        for (Purchase purchase : purchases) {
            List<PurchaseItem> purchaseItems = purchaseItemRepository.findByPurchase(purchase); // Retrieve purchase items for the current purchase
            for (PurchaseItem purchaseItem : purchaseItems) { 
                PurchaseReportDTO report = new PurchaseReportDTO();
                report.setPurchase_id(purchase.getPurchase_id());
                report.setUsername(purchase.getUsername());
                report.setDate(purchase.getDate());
                report.setTotal_amount(purchase.getTotal_amount());

                // Retrieve additional information from related entities

                // Retrieve the associated Product
                Product product = purchaseItem.getProduct();
                if (product != null) {
                    report.setProductName(product.getProductName());
               }
                
                // Retrieve the associated Category
                Category category1 = product.getCategory();
                if (category1 != null) {
                    report.setCategoryName(category1.getCategoryName());
              }
                
                purchaseReports.add(report);
            }
        }

        return purchaseReports;
    }

}
