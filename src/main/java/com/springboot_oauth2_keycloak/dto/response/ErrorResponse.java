package com.springboot_oauth2_keycloak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private String timestamp;

    public ErrorResponse(String message){
        this.message = message;
        this.timestamp = Instant.now().toString();
    }
}
