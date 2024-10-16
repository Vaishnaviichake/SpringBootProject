package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.MainException;
import com.project.Model.Category_Model;
import com.project.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category_Model> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return categoryService.getAllCategories(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category_Model> getCategoryById(@PathVariable Long id) {
        Category_Model category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new MainException("Category not found"));
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public Category_Model createCategory(@RequestBody Category_Model category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category_Model updateCategory(@PathVariable Long id, @RequestBody Category_Model category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
