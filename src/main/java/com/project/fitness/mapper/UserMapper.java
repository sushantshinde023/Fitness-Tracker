package com.project.fitness.mapper;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity(RegisterRequest request){
        User user = new User();
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        return user;
    }

    public UserResponse mapToResponse(User user){
        return new UserResponse(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());

    }
}
