package com.spring.web.SportyShoes.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	private int purchase_id;
	private String username;
	private LocalDate date;
	private double total_amount;
	
	 @OneToMany(mappedBy = "purchase")
	 private List<PurchaseItem> purchaseItems = new ArrayList<>();
	 	 
	 @Override
	 public String toString() {
	     return "Purchase [purchase_id=" + purchase_id + ", username=" + username + ", date=" + date + ", total_amount=" + total_amount + ", purchaseItems=" + (purchaseItems != null ? purchaseItems.size() : null) + "]";
	 }

}
