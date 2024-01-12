package com.example.demo.controller;

import com.example.demo.dto.User.UserRequest;
import com.example.demo.dto.User.UserResponse;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/add/{id}")
    public void addUser(@RequestBody UserRequest userRequest, @PathVariable Long id){
        userService.addUser(userRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        userService.updateById(id, userRequest);
    }




}
