package com.project.fitness.service.impl;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.mapper.UserMapper;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        User user=userMapper.mapToEntity(request);
        User savedUser=userRepository.save(user);

        return userMapper.mapToResponse(savedUser);
    }
}
