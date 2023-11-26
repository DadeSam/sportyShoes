package com.spring.web.SportyShoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.web.SportyShoes.entity.Purchase;
import com.spring.web.SportyShoes.entity.PurchaseItem;

@Repository
public interface PurchaseItemRepository extends JpaRepository <PurchaseItem, Integer>{

	List<PurchaseItem> findByPurchase(Purchase purchase);

}
