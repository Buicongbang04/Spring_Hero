package com.example.DB_Connection.controller;

import com.example.DB_Connection.dto.request.APIResponse;
import com.example.DB_Connection.dto.request.UserCreationRequest;
import com.example.DB_Connection.dto.request.UserUpdateRequest;
import com.example.DB_Connection.dto.response.UserResponse;
import com.example.DB_Connection.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Tương tác trực tiếp với service

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    // API tạo user
    @PostMapping
    APIResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return APIResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    // API Get All user
    @GetMapping
    APIResponse<List<UserResponse>> getUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("GrantedAuthority: {}", grantedAuthority));

        return APIResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    // API for Get User by ID
    @GetMapping("/{userId}")
    APIResponse<UserResponse> getUserByID(@PathVariable String userId) {
        return APIResponse.<UserResponse>builder()
                .result(userService.getUserById(userId))
                .build();
    }

    // API Update User's Information
    @PutMapping("/{userId}")
    APIResponse<UserResponse> updateInfo(@RequestBody @Valid UserUpdateRequest request, @PathVariable String userId) {
        return APIResponse.<UserResponse>builder()
                .result(userService.updateUser(request, userId))
                .build();
    }

    // API Delete User By ID
    @DeleteMapping("/{userId}")
    APIResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return APIResponse.<String>builder()
                .result("User has been deleted!")
                .build();
    }

    @GetMapping("/myinfo")
    APIResponse<UserResponse> getMyInfo() {
        return APIResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }
}
