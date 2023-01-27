package com.emreilgar.dto.request;

import com.emreilgar.repository.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {
    private String name;
    @Email
    private String email;
    @Size(min = 8,max=16)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
