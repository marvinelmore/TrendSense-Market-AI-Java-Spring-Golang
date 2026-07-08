package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreateUserRequest;
import com.trendsense.market.ai.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);
}