package com.springboot_oauth2_keycloak.service;

import com.springboot_oauth2_keycloak.dto.request.UserRequest;
import com.springboot_oauth2_keycloak.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUser();

    List<UserResponse> getUserByAddress(String address);

    UserResponse getUserById(Integer userId);

    void deleteUser(Integer userId);

    UserResponse updateUser(Integer userId, UserRequest request);
}
