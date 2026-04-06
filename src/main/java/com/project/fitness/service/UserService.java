package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
     UserResponse register(RegisterRequest user);
}
