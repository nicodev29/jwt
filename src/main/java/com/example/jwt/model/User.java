package com.example.jwt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column (name = "numeroDeContacto")
    private String numeroContacto;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    @Column (name = "status")
    private String status;

    @Column (name = "role")
    private String role;
}
