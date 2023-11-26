package com.spring.web.SportyShoes.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "category")
public class Category {
    @Id
    private int category_id;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
    @Override
    public String toString() {
        return "Category [category_id=" + category_id + ", categoryName=" + categoryName + "]";
    }
}
