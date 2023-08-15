package com.halit.dto;

import com.halit.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    private String name;
    private String password;
    private Roles role;
    private String activatedCode;
}
