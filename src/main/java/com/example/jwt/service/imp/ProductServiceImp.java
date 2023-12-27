package com.example.jwt.service.imp;

import com.example.jwt.dto.SaveProduct;
import com.example.jwt.exception.ObjetNotFoundException;
import com.example.jwt.persistence.entity.Category;
import com.example.jwt.persistence.entity.Product;
import com.example.jwt.persistence.repository.ProductRepository;
import com.example.jwt.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createProduct(SaveProduct saveProduct) {

        Product product = new Product();
        product.setNombre(saveProduct.getName());
        product.setStatus(Product.ProductStatus.ENABLED);
        product.setPrice(saveProduct.getPrice());

        Category category = new Category();
        category.setId(saveProduct.getCategoryId());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, SaveProduct saveProduct) {

        Product productFromDB = productRepository.findById(productId)
                        .orElseThrow(() -> new RuntimeException("Product not found whit id: " + productId));
        productFromDB.setNombre(saveProduct.getName());
        productFromDB.setPrice(saveProduct.getPrice());

        Category category = new Category();
        category.setId(saveProduct.getCategoryId());
        productFromDB.setCategory(category);


        return null;
    }

    @Override
    public Product disableById(Long productId) {

        Product productFromDB = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found whit id: " + productId));
        productFromDB.setStatus(Product.ProductStatus.DISABLED);

        return productRepository.save(productFromDB);
    }
}
