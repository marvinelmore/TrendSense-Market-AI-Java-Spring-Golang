package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreateUserRequest;
import com.trendsense.market.ai.dto.UserResponse;
import com.trendsense.market.ai.dto.UpdateUserRequest;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, UpdateUserRequest request);

    void deleteUser(Long id);
}