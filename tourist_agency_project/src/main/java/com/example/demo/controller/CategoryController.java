package com.example.demo.controller;

import com.example.demo.DTO.AllCategoriesDTO;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<AllCategoriesDTO>> getAllCategories() {

        List<AllCategoriesDTO> categoryDTO = categoryService.findAll();
        return ResponseEntity.ok(categoryDTO);
    }
}
