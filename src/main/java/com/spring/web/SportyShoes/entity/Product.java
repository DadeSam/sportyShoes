package com.spring.web.SportyShoes.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int product_id;
	@Column(name = "product_name")
	private String productName;
	private String description;
	private double price;
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy = "product")
    private List<PurchaseItem> purchaseItems;
	
	 @Override
	    public String toString() {
	        return "Product [product_id=" + product_id + ", productName=" + productName + ", description=" + description
	                + ", price=" + price + "]";
	    }

}
