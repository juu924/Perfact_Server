package com.perfact.server.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserRequestDto {
    private String email;
    private String passwd;

    @Builder
    public UserRequestDto(String email, String passwd){
        this.email = email;
        this.passwd = passwd;
    }
}
