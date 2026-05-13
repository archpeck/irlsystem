package com.archpeck.irlsys.dto;

import com.archpeck.irlsys.entity.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String email;
    private String password;
    private RoleUser role;
}
