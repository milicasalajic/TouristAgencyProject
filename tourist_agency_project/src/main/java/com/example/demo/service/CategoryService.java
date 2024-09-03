package com.example.demo.service;

import com.example.demo.DTO.AllPackagesDTO;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.error.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.TouristPackage;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return mapToDTO(category.get());
        } else {
            throw new CategoryNotFoundException("Category not found.");
        }
    }
    private CategoryDTO mapToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());
        if (category.getParentCategory() != null) {
            categoryDTO.setParentCategory(mapToDTO(category.getParentCategory()));
        } else {
            categoryDTO.setParentCategory(null);
        }

        return categoryDTO;
    }
}
