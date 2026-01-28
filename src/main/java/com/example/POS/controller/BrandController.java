package com.example.POS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.POS.dto.BrandDTOSave;
import com.example.POS.service.BrandService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/save")
    public String saveBrand(@RequestBody BrandDTOSave brandDTOSave) {
        String brandname = brandService.addBrand(brandDTOSave);
        return brandname + " saved successfully";
    }

}
