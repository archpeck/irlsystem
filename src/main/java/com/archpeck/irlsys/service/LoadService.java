package com.archpeck.irlsys.service;

import com.archpeck.irlsys.dto.LoadRequestDto;
import com.archpeck.irlsys.dto.LoadResponseDto;
import com.archpeck.irlsys.entity.Load;

import java.util.List;

public interface LoadService {
    List<LoadResponseDto> findAll();
    void save(LoadRequestDto loadRequestDto);

}
