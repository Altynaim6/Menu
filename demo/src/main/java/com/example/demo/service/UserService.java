package com.example.demo.service;

import com.example.demo.dto.User.UserRequest;
import com.example.demo.dto.User.UserResponse;

public interface UserService {
    UserResponse getById(Long id);

    void addUser(UserRequest userRequest, Long id);

    void deleteById(Long id);

    void updateById(Long id, UserRequest userRequest);
}
