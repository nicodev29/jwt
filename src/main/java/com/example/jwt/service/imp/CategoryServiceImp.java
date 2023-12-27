package com.example.jwt.service.imp;

import com.example.jwt.dto.SaveCategory;
import com.example.jwt.persistence.entity.Category;
import com.example.jwt.persistence.repository.CategoryRepository;
import com.example.jwt.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return Optional.empty();
    }

    @Override
    public Category createCategory(SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category updateCategory(Long categoryId, SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category desabledCategoryById(Long categoryId) {
        return null;
    }
}
