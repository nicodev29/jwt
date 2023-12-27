package com.example.jwt.controller;

import com.example.jwt.dto.SaveCategory;
import com.example.jwt.dto.SaveProduct;
import com.example.jwt.persistence.entity.Category;
import com.example.jwt.persistence.entity.Product;
import com.example.jwt.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {

        Page<Category> categoryPage = categoryService.findAll(pageable);

        if (categoryPage.hasContent()) {
            return ResponseEntity.ok(categoryPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findOneById(@PathVariable Long categoryId) {

        Optional<Category> category = categoryService.findOneById(categoryId);

        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Validated SaveCategory saveCategory) {

        Category category = categoryService.createCategory(saveCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);

    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId,
                                                   @RequestBody @Validated SaveCategory saveCategory) {

        Category category = categoryService.updateCategory(categoryId, saveCategory);
        return ResponseEntity.ok(category);

    }

    @PutMapping("/{categoryId}/disabled")
    public ResponseEntity<Category> desabledCategoryById(@PathVariable Long categoryId) {

        Category category = categoryService.desabledCategoryById(categoryId);
        return ResponseEntity.ok(category);

    }


}


