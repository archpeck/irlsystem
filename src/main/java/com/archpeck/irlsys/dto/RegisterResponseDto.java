package com.archpeck.irlsys.dto;

import com.archpeck.irlsys.entity.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDto {
    private String email;
    private RoleUser role;
    private LocalDateTime createdAt;
}