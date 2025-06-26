package com.example.DB_Connection.controller;

import com.example.DB_Connection.dto.request.APIResponse;
import com.example.DB_Connection.dto.request.AuthenticationRequest;
import com.example.DB_Connection.dto.response.AuthenticationResponse;
import com.example.DB_Connection.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/auth") // khởi tạo end-point
@RequiredArgsConstructor // auto wired beans
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    private final RestClient.Builder builder;

    @PostMapping("log-in")
    APIResponse<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authenticate(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
