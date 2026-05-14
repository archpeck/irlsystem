package com.archpeck.irlsys.controller;

import com.archpeck.irlsys.dto.LoadRequestDto;
import com.archpeck.irlsys.dto.LoadResponseDto;
import com.archpeck.irlsys.dto.mapper.LoadMapper;
import com.archpeck.irlsys.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoadController {

    private final LoadService loadService;

    @GetMapping("/loads")
    public String loads(Model model) {
        List<LoadResponseDto> loads = loadService.findAll();
        model.addAttribute("loads", loads);
        return "loads";
    }

    @GetMapping("/create")
    public String create(Model model) {
        LoadRequestDto load =  new LoadRequestDto();
        model.addAttribute("load", load);
        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("load")  LoadRequestDto load) {
        loadService.save(load);
        return "redirect:/loads";
    }
}
