package com.example.POS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;
import com.example.POS.entity.Category;
import com.example.POS.repo.CategoryRepo;
import com.example.POS.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public String addCategory(CategoryDTOSave categoryDTOSave) {
        Category category = new Category(
                categoryDTOSave.getCatName(),
                categoryDTOSave.isActive());
        categoryRepo.save(category);
        return "Category added successfully: " + category.getCatName();
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO(
                    category.getCatId(),
                    category.getCatName(),
                    category.isActive());
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public String updateCategory(CategoryDTOUpdate categoryDTOUpdate) {
        Category category = categoryRepo.findById(categoryDTOUpdate.getCatid())
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryDTOUpdate.getCatid()));
        category.setCatName(categoryDTOUpdate.getCatname());
        category.setActive(categoryDTOUpdate.isActive());
        categoryRepo.save(category);
        return "Category updated successfully: " + category.getCatName();
    }

    @Override
    public String deleteCategory(int catId) {
        if (!categoryRepo.existsById(catId)) {
            return "Category not found with ID: " + catId;
        }
        categoryRepo.deleteById(catId);
        return "Category deleted successfully with ID: " + catId;
    }

}
