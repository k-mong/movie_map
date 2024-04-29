package com.art.location.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String nickName;
    private String password;
    private String address;
    private Integer manner;
    private String email;
    private String imagePath;
    private UserRole role = UserRole.ROLE_USER;
    private LocalDateTime deletedAt;
}
