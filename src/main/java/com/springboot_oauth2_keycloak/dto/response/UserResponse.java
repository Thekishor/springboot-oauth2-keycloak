package com.springboot_oauth2_keycloak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private Integer userId;

    private String userName;

    private String email;

    private String password;

    private String address;
}
