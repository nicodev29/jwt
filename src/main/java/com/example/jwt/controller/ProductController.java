package com.example.jwt.controller;

import com.example.jwt.dto.SaveProduct;
import com.example.jwt.persistence.entity.Product;
import com.example.jwt.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {

        Page<Product> productPage = productService.findAll(pageable);

        if (productPage.hasContent()) {
            return ResponseEntity.ok(productPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findOneById(@PathVariable Long productId) {

        Optional<Product> product = productService.findOneById(productId);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Validated SaveProduct saveProduct) {

        Product product = productService.createProduct(saveProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
                                                 @RequestBody @Validated SaveProduct saveProduct) {

        Product product = productService.updateProduct(productId, saveProduct);
        return ResponseEntity.ok(product);

    }
    @PutMapping("/{productId}/disabled")
    public ResponseEntity<Product> disableById(@PathVariable Long productId) {

        Product product = productService.disableById(productId);
        return ResponseEntity.ok(product);

    }


}


