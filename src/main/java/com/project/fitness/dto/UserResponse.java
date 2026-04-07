package com.project.fitness.dto;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String password,
        String firstName,
        String lastName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
