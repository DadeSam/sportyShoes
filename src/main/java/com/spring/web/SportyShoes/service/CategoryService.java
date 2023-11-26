package com.spring.web.SportyShoes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.SportyShoes.entity.Category;

@Service
public interface CategoryService {
List <Category> getAllCategories();
}
