package com.example.POS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "brand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id", nullable = false, unique = true)
    private int brandId;
    @Column(name = "brand_name", nullable = false, length = 45)
    private String brandName;
    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    public Brand(String brandName, boolean active) {
        this.brandName = brandName;
        this.active = active;
    }
}
