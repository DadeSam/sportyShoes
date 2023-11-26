package com.spring.web.SportyShoes.controller;
import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.web.SportyShoes.dto.PurchaseReportDTO;
import com.spring.web.SportyShoes.service.PurchaseService;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/ViewPurchaseReport")
    public String showPurchaseReport(
    	    @RequestParam(name = "category", required = false, defaultValue = "") String categoryName,
    	    @RequestParam(name = "date", required = false, defaultValue = "") String dateString,
    	    Model model) {
    	    LocalDate parsedDate = null;
    	    List<PurchaseReportDTO> purchaseReports;
    	    if (!dateString.isEmpty()) {
    	        parsedDate = LocalDate.parse(dateString);  }
    	    if (!categoryName.isEmpty() && parsedDate != null) {
    	        // No selection made, retrieve all purchase reports
    	       purchaseReports = purchaseService.getPurchaseReports(categoryName, parsedDate);       
    	    } else {	    	
    	        // Selection made, retrieve purchase reports based on category and date
    	        purchaseReports = purchaseService.getPurchaseReports("", null);}
    	    model.addAttribute("purchaseReports", purchaseReports);
    	    model.addAttribute("selectedCategory", categoryName);
    	    model.addAttribute("selectedDate", dateString);
    	    return "ViewPurchaseReport";
    }
}
