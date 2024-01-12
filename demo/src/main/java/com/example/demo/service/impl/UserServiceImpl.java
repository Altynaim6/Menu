package com.example.demo.service.impl;

import com.example.demo.dto.User.UserRequest;
import com.example.demo.dto.User.UserResponse;
import com.example.demo.entites.Menu;
import com.example.demo.entites.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.MenuRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MenuRepository menuRepository;

    @Override
    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        return userMapper.toDto(user.get());
    }

    @Override
    public void addUser(UserRequest userRequest, Long id) {
        User user = new User();
        user.setName(userRequest.getName());
        User user1 = userRepository.saveAndFlush(user);
        Optional<Menu> menu = menuRepository.findById(id);
        List<User> userList = new ArrayList<>();
        if(menu.get().getUsers() != null) userList = menu.get().getUsers();
        userList.add(user1);
        menu.get().setUsers(userList);
        menuRepository.save(menu.get());
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.findById(id).isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        userRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        user.get().setName(userRequest.getName());

        userRepository.save(user.get());
    }
}

