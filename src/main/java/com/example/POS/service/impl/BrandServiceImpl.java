package com.example.POS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.POS.dto.BrandDTO;
import com.example.POS.dto.BrandDTOSave;
import com.example.POS.entity.Brand;
import com.example.POS.repo.BrandRepo;
import com.example.POS.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Override
    public String addBrand(BrandDTOSave brandDTOSave) {
        Brand brand = new Brand(
                brandDTOSave.getBrandName(),
                brandDTOSave.isActive());
        brandRepo.save(brand);
        return "Brand added successfully: " + brand.getBrandName();
    }

    @Override
    public List<BrandDTO> getAllCategory() {
        List<Brand> brands = brandRepo.findAll();
        List<BrandDTO> brandDTOList = new ArrayList<>();
        for (Brand brand : brands) {
            BrandDTO brandDTO = new BrandDTO(
                    brand.getBrandId(),
                    brand.getBrandName(),
                    brand.isActive());
            brandDTOList.add(brandDTO);
        }
        return brandDTOList;
    }

}
