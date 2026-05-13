package com.archpeck.irlsys.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadRequestDto {
    private String loadingCity;
    private String unloadingCity;
    private String cargoType;
    private BigDecimal weight;
    private BigDecimal price;
}
