package com.example.firstapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductUser {
    @Id
    private long id;
    private String userName;
    private String password;
}
