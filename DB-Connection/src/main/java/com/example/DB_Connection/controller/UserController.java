package com.example.DB_Connection.controller;

import com.example.DB_Connection.dto.request.UserCreationRequest;
import com.example.DB_Connection.dto.request.UserUpdateRequest;
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
    User createUser(@RequestBody @Valid UserCreationRequest request){
        return userService.createUser(request);
    }

    // API Get All user
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    // API for Get User by ID
    @GetMapping("/{userId}")
    User getUserByID(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    // API Update User's Information
    @PutMapping("/{userId}")
    User updateInfo(@RequestBody UserUpdateRequest request, @PathVariable String userId){
        return userService.updateUser(request, userId);
    }

    // API Delete User By ID
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User deleted successfully!";
    }
}
