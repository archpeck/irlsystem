package com.archpeck.irlsys.dto;

import com.archpeck.irlsys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadResponseDto {
    private String loadingCity;
    private String unloadingCity;
    private String cargoType;
    private BigDecimal weight;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private RegisterResponseDto user;
}
