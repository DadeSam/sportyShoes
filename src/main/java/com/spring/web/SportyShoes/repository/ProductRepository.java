package com.spring.web.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.web.SportyShoes.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
