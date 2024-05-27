package com.example.youtubeSheet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
    private String username;

    @NotBlank(message = "이메일이 공백일 수 없습니다")
    @Email
    private String email;

    @NotBlank(message = "비밀번호가 공백일 수 없습니다")
    private String password;

    @NotBlank(message = "확인 비밀번호가 공백일 수 없습니다")
    private String confirmPassword;

}