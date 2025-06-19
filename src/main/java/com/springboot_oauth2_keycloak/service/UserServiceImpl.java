package com.springboot_oauth2_keycloak.service;

import com.springboot_oauth2_keycloak.dto.request.UserRequest;
import com.springboot_oauth2_keycloak.dto.response.UserResponse;
import com.springboot_oauth2_keycloak.entities.User;
import com.springboot_oauth2_keycloak.exception.UserAlreadyExistsException;
import com.springboot_oauth2_keycloak.exception.UserNotFoundException;
import com.springboot_oauth2_keycloak.mapper.UserMapper;
import com.springboot_oauth2_keycloak.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            log.error("User already exists with email");
            throw new UserAlreadyExistsException("User already exists with email");
        }
        User user = userMapper.userRequestToUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        log.info("User Created Successfully");
        return userMapper.userToUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        log.info("Get All Users from db");
        return users.stream().map(userMapper::userToUserResponse).toList();
    }

    @Override
    public List<UserResponse> getUserByAddress(String address) {
        List<User> users = userRepository.findUserByAddress(address);
        return users.stream().map(userMapper::userToUserResponse).toList();
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id"));
        log.info("User Found With Id: {}", user.getId());
        return userMapper.userToUserResponse(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id"));
        userRepository.delete(user);
        log.info("User Deleted Successfully");
    }

    @Override
    public UserResponse updateUser(Integer userId, UserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id"));
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAddress(request.getAddress());
        log.info("User Updated Successfully");
        return userMapper.userToUserResponse(userRepository.save(user));
    }
}
