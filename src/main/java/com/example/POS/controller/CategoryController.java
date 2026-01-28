package com.example.POS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;
import com.example.POS.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public String saveCategory(@RequestBody CategoryDTOSave categoryDTOSave) {
        String catname = categoryService.addCategory(categoryDTOSave);
        return "Category " + catname + " saved successfully";
    }

    @GetMapping
    public List<CategoryDTO> getAllCategory() {
        List<CategoryDTO> allCategories = categoryService.getAllCategory();
        return allCategories;
    }

    @PutMapping("/update")
    public String updateCategory(@RequestBody CategoryDTOUpdate categoryDTOUpdate) {
        String response = categoryService.updateCategory(categoryDTOUpdate);
        return response;
    }

    @DeleteMapping("/delete/{catId}")
    public String deleteCategory(@PathVariable int catId) {
        String response = categoryService.deleteCategory(catId);
        return response;
    }
}