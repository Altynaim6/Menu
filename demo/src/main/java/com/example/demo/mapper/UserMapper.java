package com.example.demo.mapper;

import com.example.demo.dto.User.UserResponse;
import com.example.demo.entites.User;

import java.util.Optional;

public interface UserMapper {
    UserResponse toDto(User user);
}