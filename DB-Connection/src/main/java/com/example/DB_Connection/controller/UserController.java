package com.example.DB_Connection.controller;

import com.example.DB_Connection.dto.request.APIResponse;
import com.example.DB_Connection.dto.request.UserCreationRequest;
import com.example.DB_Connection.dto.request.UserUpdateRequest;
import com.example.DB_Connection.dto.response.UserResponse;
import com.example.DB_Connection.entity.User;
import com.example.DB_Connection.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Tương tác trực tiếp với service

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // API tạo user
    @PostMapping
    APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        APIResponse<User> response = new APIResponse<>();

        response.setResult(userService.createUser(request));

        return response;
    }

    // API Get All user
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    // API for Get User by ID
    @GetMapping("/{userId}")
    UserResponse getUserByID(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    // API Update User's Information
    @PutMapping("/{userId}")
    UserResponse updateInfo(@RequestBody @Valid UserUpdateRequest request, @PathVariable String userId) {
        return userService.updateUser(request, userId);
    }

    // API Delete User By ID
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted successfully!";
    }
}
