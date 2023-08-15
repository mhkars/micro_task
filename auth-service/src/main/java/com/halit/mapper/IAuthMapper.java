package com.halit.mapper;

import com.halit.dto.LoginRequestDto;
import com.halit.dto.LoginResponseDto;
import com.halit.dto.RegisterRequestDto;
import com.halit.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

        IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    LoginResponseDto toLoginResponseDto(final Auth auth);
    RegisterRequestDto toRegisterRequestDto(final Auth auth);
//
    Auth toAuth(final RegisterRequestDto dto);
//
    Auth toAuth(final LoginRequestDto dto);
}