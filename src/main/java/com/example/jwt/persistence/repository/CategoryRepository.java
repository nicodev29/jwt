package com.example.jwt.persistence.repository;

import com.example.jwt.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Long> {
}
