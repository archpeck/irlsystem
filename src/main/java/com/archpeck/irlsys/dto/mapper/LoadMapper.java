package com.archpeck.irlsys.dto.mapper;

import com.archpeck.irlsys.dto.LoadRequestDto;
import com.archpeck.irlsys.dto.LoadResponseDto;
import com.archpeck.irlsys.entity.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoadMapper {
    LoadResponseDto toDto(Load load);
    Load toEntity(LoadRequestDto loadRequestDto);
}
