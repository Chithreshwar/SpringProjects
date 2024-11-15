package com.example.firstapi.entity;

import lombok.Data;

import java.util.List;


@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private List<Roles> roles;
}
