package com.example.POS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.Brand;

public interface BrandRepo extends JpaRepository<Brand, Integer> {

}
