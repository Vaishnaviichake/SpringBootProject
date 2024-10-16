package com.project.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.MainException;
import com.project.Model.Category_Model;
import com.project.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category_Model> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Optional<Category_Model> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category_Model createCategory(Category_Model category) {
        return categoryRepository.save(category);
    }

    public Category_Model updateCategory(Long id, Category_Model categoryDetails) {
        Category_Model category = categoryRepository.findById(id)
                .orElseThrow(() -> new MainException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category_Model category = categoryRepository.findById(id)
                .orElseThrow(() -> new MainException("Category not found"));
        categoryRepository.delete(category);
    }
}

