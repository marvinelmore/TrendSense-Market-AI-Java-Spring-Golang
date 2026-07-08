package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreateUserRequest;
import com.trendsense.market.ai.dto.UserResponse;
import com.trendsense.market.ai.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse user = userService.createUser(request);

        return ApiResponse.success("User created successfully", user);
    }
}