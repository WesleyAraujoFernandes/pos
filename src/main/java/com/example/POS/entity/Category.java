package com.example.POS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id", nullable = false, unique = true)
    private int catId;
    @Column(name = "cat_name", nullable = false, length = 45)
    private String catName;
    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    public Category(String catName, boolean active) {
        this.catName = catName;
        this.active = active;
    }
}
