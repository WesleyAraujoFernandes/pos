package com.example.POS.service;

import java.util.List;

import com.example.POS.dto.BrandDTO;
import com.example.POS.dto.BrandDTOSave;

public interface BrandService {

    String addBrand(BrandDTOSave brandDTOSave);

    List<BrandDTO> getAllCategory();
}
