package com.springboot_oauth2_keycloak.controller;

import com.springboot_oauth2_keycloak.dto.request.UserRequest;
import com.springboot_oauth2_keycloak.dto.response.HttpResponse;
import com.springboot_oauth2_keycloak.dto.response.UserResponse;
import com.springboot_oauth2_keycloak.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        UserResponse userResponse = userService.createUser(request);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponseList = userService.getAllUser();
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @GetMapping("/address")
    @PreAuthorize("hasRole('client_user') or hasRole('client_admin')")
    public ResponseEntity<List<UserResponse>> findUserByAddress(@RequestParam("address") String address) {
        List<UserResponse> userByAddress = userService.getUserByAddress(address);
        return new ResponseEntity<>(userByAddress, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('client_user') or hasRole('client_admin')")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") Integer userId) {
        UserResponse userResponse = userService.getUserById(userId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<HttpResponse> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new HttpResponse("User Deleted Successfully"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('client_user') or hasRole('client_admin')")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("userId") Integer userId,
            @Valid @RequestBody UserRequest request
    ) {
        UserResponse userResponse = userService.updateUser(userId, request);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
