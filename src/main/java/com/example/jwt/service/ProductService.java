package com.example.jwt.service;

import com.example.jwt.dto.SaveProduct;
import com.example.jwt.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService{
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    Product createProduct(SaveProduct saveProduct);

    Product updateProduct(Long productId, SaveProduct saveProduct);

    Product disableById(Long productId);
}
