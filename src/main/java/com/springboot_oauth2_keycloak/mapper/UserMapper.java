package com.springboot_oauth2_keycloak.mapper;

import com.springboot_oauth2_keycloak.dto.request.UserRequest;
import com.springboot_oauth2_keycloak.dto.response.UserResponse;
import com.springboot_oauth2_keycloak.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestToUser(UserRequest request);

    @Mapping(target = "userId", source = "user.id")
    UserResponse userToUserResponse(User user);
}
