package com.project.fitness.service.impl;

import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
}
