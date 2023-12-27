package com.example.jwt.service;

import com.example.jwt.dto.SaveCategory;
import com.example.jwt.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOneById(Long categoryId);

    Category createCategory(SaveCategory saveCategory);

    Category updateCategory(Long categoryId, SaveCategory saveCategory);

    Category desabledCategoryById(Long categoryId);
}
