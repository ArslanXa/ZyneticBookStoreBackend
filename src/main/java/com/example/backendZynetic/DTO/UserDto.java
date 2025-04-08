package com.example.backendZynetic.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private String email;
    private String password;

    public UserDto toUserDTO() {
        return UserDto.builder()
                    .email(email)
                    .password(password)
                    .build();
        }
    }

