package com.emreilgar.mapper;

import com.emreilgar.dto.request.RegisterRequestDto;
import com.emreilgar.dto.response.RegisterResponseDto;
import com.emreilgar.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IMapper {

    IMapper INSTANCE = Mappers.getMapper(IMapper.class);
    UserEntity fromRegisterRequestDto(final RegisterRequestDto dto);
    RegisterResponseDto fromUserEntity(final UserEntity entity);
}
