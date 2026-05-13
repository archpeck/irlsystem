package com.archpeck.irlsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loads")
@Getter
@Setter
@NoArgsConstructor
public class Load {
    @Id
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "loading_city", nullable = false)
    private String loadingCity;
    @Column(name = "unloading_city", nullable = false)
    private String unloadingCity;

    @Column(name = "cargo_type", nullable = false)
    private String cargoType;
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Load(String loadingCity, String unloadingCity, String cargoType, BigDecimal weight, BigDecimal price) {
        this.loadingCity = loadingCity;
        this.unloadingCity = unloadingCity;
        this.cargoType = cargoType;
        this.weight = weight;
        this.price = price;
    }
}
