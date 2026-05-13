package com.archpeck.irlsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleUser role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if(id == null) {
            this.id = UUID.randomUUID();
        }
        this.createdAt = LocalDateTime.now();
    }

    public User(String email, String passwordHash, RoleUser role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }
}
