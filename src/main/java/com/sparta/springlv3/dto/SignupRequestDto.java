package com.sparta.springlv3.dto;

import com.sparta.springlv3.entity.UserRoleEnum;
import com.sparta.springlv3.entity.UserTeamEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")
    private String password;
    @NotNull
    private UserTeamEnum team;
    @NotNull
    private UserRoleEnum role;
}
