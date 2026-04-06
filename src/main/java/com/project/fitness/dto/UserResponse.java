package com.project.fitness.dto;

public record UserResponse(
        Long id,
        String email,
        String password,
        String firstName,
        String lastName
) {
}
