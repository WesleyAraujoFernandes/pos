package com.example.POS.service;

import java.util.List;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;

public interface CategoryService {

    String addCategory(CategoryDTOSave categoryDTOSave);

    List<CategoryDTO> getAllCategory();

    String updateCategory(CategoryDTOUpdate categoryDTOUpdate);

    String deleteCategory(int catId);
}
