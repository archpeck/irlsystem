package com.archpeck.irlsys.service;

import com.archpeck.irlsys.dto.LoadRequestDto;
import com.archpeck.irlsys.dto.LoadResponseDto;
import com.archpeck.irlsys.dto.mapper.LoadMapper;
import com.archpeck.irlsys.entity.Load;
import com.archpeck.irlsys.entity.User;
import com.archpeck.irlsys.repository.LoadRepository;
import com.archpeck.irlsys.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl  implements LoadService {

    private final LoadRepository loadRepository;
    private final UserRepository userRepository;
    private final LoadMapper loadMapper;

    @Override
    public List<LoadResponseDto> findAll() {
        return loadRepository.findAll().stream().map(loadMapper::toDto).toList();
    }

    @Override
    public void save(LoadRequestDto loadRequestDto) {
        Load load = loadMapper.toEntity(loadRequestDto);
        CustomUserDetails principal =
                (CustomUserDetails) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        User user = principal.getUser();
        load.setUser(user);
        loadRepository.save(load);

    }

}
