package com.archpeck.irlsys.controller;

import com.archpeck.irlsys.dto.RegisterRequestDto;
import com.archpeck.irlsys.entity.User;
import com.archpeck.irlsys.service.AuthService;
import com.archpeck.irlsys.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequestDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequestDto dto) {
        authService.register(dto);
        return "redirect:/login";
    }

    @GetMapping("/me")
    public String me(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails.getUser());
        return "me";
    }
}
