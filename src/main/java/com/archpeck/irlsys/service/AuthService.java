package com.archpeck.irlsys.service;

import com.archpeck.irlsys.dto.RegisterRequestDto;
import com.archpeck.irlsys.dto.RegisterResponseDto;
import com.archpeck.irlsys.entity.User;
import com.archpeck.irlsys.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequestDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = new User(
                dto.getEmail(),
                encodedPassword,
                dto.getRole()
        );
        userRepository.save(user);

    }

}
