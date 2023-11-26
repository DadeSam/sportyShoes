package com.spring.web.SportyShoes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReportDTO {
	private int purchase_id;
    private String username;
    private LocalDate date;
    private double total_amount;
    private String productName;
    private String description;
    private String categoryName;
}
