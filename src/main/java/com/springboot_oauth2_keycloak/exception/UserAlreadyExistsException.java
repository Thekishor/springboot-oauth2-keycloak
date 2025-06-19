package com.springboot_oauth2_keycloak.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String resourcename) {
        super(resourcename);
    }
}
