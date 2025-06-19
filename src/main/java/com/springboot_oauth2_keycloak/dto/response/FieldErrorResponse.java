package com.springboot_oauth2_keycloak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorResponse {

    private Map<String,String> message;
    private String timestamp;

    public FieldErrorResponse(Map<String, String> message){
        this.message = message;
        this.timestamp = Instant.now().toString();
    }
}
