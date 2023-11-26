package com.spring.web.SportyShoes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="purchase_item")
public class PurchaseItem {
	@Id
	private int purchase_item_id;
	@ManyToOne
    @JoinColumn(name = "purchase_id")
	private Purchase purchase;
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	private int quantity;
	
	@Override
	public String toString() {
		return "PurchaseItem [purchase_item_id=" + purchase_item_id + ", purchase=" + (purchase != null ? purchase.getPurchase_id() : null) + ", product=" + (product != null ? product.getProduct_id() : null) + ", quantity=" + quantity + "]";
	}
	
	
}
