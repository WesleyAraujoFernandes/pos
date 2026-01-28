package com.example.POS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
