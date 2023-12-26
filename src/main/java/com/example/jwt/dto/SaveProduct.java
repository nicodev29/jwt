package com.example.jwt.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SaveProduct implements Serializable {

    private String name;
    private BigDecimal price;
    private Long categoryId;

}
